package com.daw.proyectotalleralex.Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.daw.proyectotalleralex.DTO.Cesta;
import com.daw.proyectotalleralex.DTO.CestaPK;
import com.daw.proyectotalleralex.DTO.Citas;
import com.daw.proyectotalleralex.DTO.Facturas;
import com.daw.proyectotalleralex.DTO.Partes;
import com.daw.proyectotalleralex.DTO.Productos;
import com.daw.proyectotalleralex.DTO.Puntuaciones;
import com.daw.proyectotalleralex.DTO.PuntuacionesPK;
import com.daw.proyectotalleralex.DTO.RegistroFactura;
import com.daw.proyectotalleralex.DTO.Suscrip;

import com.daw.proyectotalleralex.DTO.Usuario;
import com.daw.proyectotalleralex.DTO.Vistacestacompleta;
import com.daw.proyectotalleralex.DTO.Vistafacturacompleta;
import com.daw.proyectotalleralex.DTO.Vistapuntuaciones;
import com.daw.proyectotalleralex.Service.CestaService;
import com.daw.proyectotalleralex.Service.CitasService;
import com.daw.proyectotalleralex.Service.FacturasService;
import com.daw.proyectotalleralex.Service.PartesService;
import com.daw.proyectotalleralex.Service.ProductosService;
import com.daw.proyectotalleralex.Service.PuntuacionesService;
import com.daw.proyectotalleralex.Service.RegistroFacturaService;
import com.daw.proyectotalleralex.Service.SuscripService;

import com.daw.proyectotalleralex.Service.UsuarioService;
import com.daw.proyectotalleralex.Service.VistacestacompletaService;
import com.daw.proyectotalleralex.Service.VistafacturacompletaService;
import com.daw.proyectotalleralex.Service.VistapuntuacionesService;
import com.daw.proyectotalleralex.uploadStorage.StorageService;
import com.daw.proyectotalleralex.utils.EmailUtils;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.html.WebColors;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@Controller
public class MainController {

	@Autowired
	UsuarioService usuarioServicio;
	
	@Autowired
	ProductosService productosServicio;
	
	@Autowired
	CestaService cestaServ;
	
	@Autowired
	VistacestacompletaService vistaCesServ;
	
	@Autowired
	FacturasService factsServ;
	
	@Autowired
	RegistroFacturaService registrServ;
	
	@Autowired
	VistafacturacompletaService visRegServ;
	
	@Autowired
	CitasService citasServ;
	
	@Autowired
	SuscripService susserv;
	
	@Autowired
	PartesService partesserv;
	
	@Autowired
	PuntuacionesService puntuserv;
	
	@Autowired
	VistapuntuacionesService vps;
	
	@Autowired
	ServletContext sc;
	
	@Autowired
    StorageService ss;
	
	@GetMapping("/")
	public String primeraEjecucion(Model modelo, HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		return "redirect:/irInicio";
	}
	
	@GetMapping("/irInicio")
	public String inicio(Model modelo, HttpServletRequest request, HttpServletResponse response) {
		
		List<Productos> listProductos = productosServicio.FindAll();
		
		JSONObject jsonprod = new JSONObject();
		
		JSONObject jsonprodCompleto = new JSONObject();
		
		modelo.addAttribute("miListaProductos",listProductos);
		
		for (Productos productos : listProductos) {
			jsonprod.put("codProd", productos.getCodProd());
			jsonprod.put("nomProd", productos.getNomProd());
			jsonprod.put("imgProd", productos.getImgProd());
			jsonprod.put("desProd", productos.getDescripProd());
			jsonprod.put("uniProd", productos.getUnidadesProd());
			jsonprod.put("punProd", productos.getPuntuacionProd());
			
			jsonprodCompleto.put(String.valueOf(productos.getCodProd()), jsonprod);
			
			jsonprod = new JSONObject();
			
		}
		
		response.setContentType("aplication/json");
		modelo.addAttribute("jsonprodCompleto",jsonprodCompleto.toString());
		
		try {
			response.getWriter().print(jsonprodCompleto.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "index";
	}
	
	@GetMapping("/irLogin")
	public String moverLogin(Model modelo) {
		return "logreg";
	}
	
	@GetMapping("/irMapa")
	public String verUbi(Model modelo) {
		return "ubicacion";
	}
	
	@GetMapping("/irConf")
	public String confirmar(Model modelo) {
		return "confirmar";
	}
	
	@GetMapping("/cerrarSesion")
	public String logoutt(Model modelo,HttpServletRequest request) {
		HttpSession miSesion = request.getSession();
		
		if(miSesion!=null) {
			miSesion.invalidate();
		}
		
		return "redirect:/irInicio";
	}
	
	@GetMapping("/iniciaSesion")
	public String iniciaSes(Model modelo, HttpServletRequest request, HttpServletResponse response) {
		HttpSession miSesion = request.getSession();
		
		String email = request.getParameter("emailL");
		String contra = request.getParameter("contraL");
		String error="";
		
		
		if(email != null && contra != null) {
			Usuario miUsu = usuarioServicio.encuentraEmailUsu(email);
			if(miUsu != null) {
				if(miUsu.getEmailusu().equals(email)) {
					if(miUsu.getContrausu().equals(contra)) {
						miSesion.setAttribute("usuario", miUsu);
						
						List <Cesta> miCestaCompleta = cestaServ.buscarMiListaProd(miUsu.getDniusu());
						
						int prodTotal=0;
						int precioTotal=0;
						
						for (Cesta cesta : miCestaCompleta) {
							prodTotal+= cesta.getUnidadesCesta();
							precioTotal += cesta.getTotalpreciocesta();
						}
						
						miSesion.setAttribute("prodTotal", prodTotal);
						miSesion.setAttribute("precioTotal", precioTotal);
						
						List<Productos> listProductos = productosServicio.FindAll();
						
						JSONObject jsonprod = new JSONObject();
						
						JSONObject jsonprodCompleto = new JSONObject();
						
						modelo.addAttribute("miListaProductos",listProductos);
						
						for (Productos productos : listProductos) {
							jsonprod.put("codProd", productos.getCodProd());
							jsonprod.put("nomProd", productos.getNomProd());
							jsonprod.put("imgProd", productos.getImgProd());
							jsonprod.put("desProd", productos.getDescripProd());
							jsonprod.put("uniProd", productos.getUnidadesProd());
							jsonprod.put("punProd", productos.getPuntuacionProd());
							
							jsonprodCompleto.put(String.valueOf(productos.getCodProd()), jsonprod);
							
							jsonprod = new JSONObject();
							
						}
						
						response.setContentType("aplication/json");
						modelo.addAttribute("jsonprodCompleto",jsonprodCompleto.toString());
						
						try {
							response.getWriter().print(jsonprodCompleto.toString());
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
						return "index";
						
					}else {
						error="Contraseña Errónea";
						request.setAttribute("error", error);
						return "logreg";
					}
				}
			}
		}
		error="Email y Contraseña Incorrectos";
		request.setAttribute("error", error);
		return "logreg";
	}
	
	@GetMapping("/registrarse")
	public String registro(Model modelo, HttpServletRequest request) {
		HttpSession miSesion = request.getSession();
		
		String nombre = request.getParameter("nomreg");
		String apellidos = request.getParameter("apereg");
		String email = request.getParameter("emailreg");
		String contra = request.getParameter("contrareg");
		String localidad = request.getParameter("localreg");
		String dni = request.getParameter("dnireg");
		
		Usuario miUsu;
		
		miUsu = new Usuario(dni,nombre,apellidos,email,contra,localidad,"C");
		
		usuarioServicio.save(miUsu);
		
		miSesion.setAttribute("usuario", miUsu);
		
		
		return "redirect:/irInicio";
	}
	
	@GetMapping("/buscar")
	public String busqueda(HttpServletRequest request,Model modelo) {
		
		String categoria = request.getParameter("cate");
		
		String verTodo = request.getParameter("tipoTodo");
		
		
		
		HttpSession miSesion = request.getSession();
		
		miSesion.setAttribute("cateSel", categoria);
		
		
		List<Productos> listProductosCate = productosServicio.buscarCategoria(categoria);
		
		
		
		miSesion.setAttribute("listProductosCate", listProductosCate);
		
		if(verTodo!=null) {
			miSesion.setAttribute("cateSel", "");
			miSesion.setAttribute("listProductosCate", null);
		}
		
		return "redirect:/irTienda";
	}
	
	@GetMapping("/irTienda")
	public String cargaProductosTienda(Model modelo, HttpServletRequest request, HttpServletResponse response ) {
		
		HttpSession miSesion = request.getSession();
		
		List<Productos> listProductosCate = (List<Productos>) miSesion.getAttribute("listProductosCate");
		
		List<Productos> listProductos;
		
		String busca = request.getParameter("busca");
		
		
		
		if(listProductosCate==null) {
			if(busca!=null) {
				listProductos = productosServicio.buscarProductos(busca);
				modelo.addAttribute("buscado",busca);
			}else {
				listProductos = productosServicio.FindAll();
			}
		}else {
			listProductos=listProductosCate;
		}
		
		if(request.getParameter("tipoTodo")!=null) {
			listProductos = productosServicio.FindAll();
		}
		
		
		JSONObject jsonprod = new JSONObject();
		
		JSONObject jsonprodCompleto = new JSONObject();
		
		modelo.addAttribute("miListaProductos",listProductos);
		
		for (Productos productos : listProductos) {
			jsonprod.put("codProd", productos.getCodProd());
			jsonprod.put("nomProd", productos.getNomProd());
			jsonprod.put("imgProd", productos.getImgProd());
			jsonprod.put("desProd", productos.getDescripProd());
			jsonprod.put("uniProd", productos.getUnidadesProd());
			jsonprod.put("punProd", productos.getPuntuacionProd());
			jsonprod.put("fecProd", productos.getFechaProd());
			jsonprod.put("precProd", productos.getPrecioProd());
			jsonprod.put("cateProd", productos.getCategoriaProd());
			
			jsonprodCompleto.put(String.valueOf(productos.getCodProd()), jsonprod);
			
			jsonprod = new JSONObject();
			
		}
		
		response.setContentType("aplication/json");
		modelo.addAttribute("jsonprodCompleto2",jsonprodCompleto.toString());
		
		try {
			response.getWriter().print(jsonprodCompleto.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "tienda";
	}
	
	@GetMapping("/verProducto")
	public String cargarMiProducto(Model modelo, HttpServletRequest request, HttpServletResponse response ) {
		
		int miCod =Integer.parseInt( request.getParameter("codigoProducto"));
		
		List<Productos> listaMiProd = productosServicio.buscarMiProd(miCod);
		
		Productos miProd = listaMiProd.get(0);
		
		modelo.addAttribute("miProd",miProd);
		
		return "producto";
		
	}
	
	@GetMapping("/anadirCesta")
	public String anadeCesta(Model modelo, HttpServletRequest request, HttpServletResponse response  ) {
		
		String sitio = request.getParameter("sitio");
		
		HttpSession miSesion = request.getSession();
		
		int uni;
		
		String cantidad = request.getParameter("cantidad");
		
		int codProd = Integer.parseInt(request.getParameter("codigoProd"));
		
		Usuario miUsu = (Usuario) miSesion.getAttribute("usuario");
		
		String dniUsu = miUsu.getDniusu();
		
		if(cantidad!=null) {
			uni = Integer.parseInt(cantidad);
		}else {
			uni = 1;
		}
		
		List<Productos> listaMiProd = productosServicio.buscarMiProd(codProd);
		
		Productos miProd = listaMiProd.get(0);
		
		CestaPK cestaPK = new CestaPK(dniUsu,codProd);
		
		int totalPrecio = (int) (uni * Math.round(miProd.getPrecioProd()));
		
		
		List <Cesta> miLCesta =  cestaServ.buscarMiProd(dniUsu, codProd);
		if(miLCesta.size()>0) {
			Cesta cestaExistente = miLCesta.get(0);
			int uniActual = cestaExistente.getUnidadesCesta();
			int precActual = (int) cestaExistente.getTotalpreciocesta();
			
			uniActual = uniActual + uni;
			precActual = precActual + totalPrecio;
			
			cestaExistente.setTotalpreciocesta(precActual);
			cestaExistente.setUnidadesCesta(uniActual);
			
			cestaServ.save(cestaExistente);
			
		}else {
			Cesta miCesta = new Cesta(cestaPK,uni,totalPrecio);
			
			cestaServ.save(miCesta);
		}
		
		
		List <Cesta> miCestaCompleta = cestaServ.buscarMiListaProd(dniUsu);
		
		int prodTotal=0;
		int precioTotal=0;
		
		for (Cesta cesta : miCestaCompleta) {
			prodTotal+= cesta.getUnidadesCesta();
			precioTotal += cesta.getTotalpreciocesta();
		}
		
		miSesion.setAttribute("prodTotal", prodTotal);
		miSesion.setAttribute("precioTotal", precioTotal);
		
		
		
		if(sitio.equals("tienda")) {
			return "redirect:/irTienda";
		}else if(sitio.equals("producto"))  {
			return "redirect:/verProducto?codigoProducto="+codProd;
		}else if(sitio.equals("parte"))  {
			return "redirect:/vercreaParte";
		}
		
		
		
		return sitio;
	}
	
	@GetMapping("/irCesta")
	public String vamosCesta(Model modelo, HttpServletRequest request, HttpServletResponse response  ) {
		
		HttpSession miSesion = request.getSession();
		
		Usuario miUsu = (Usuario) miSesion.getAttribute("usuario");
		
		/*List <Cesta> miCestaCompleta = cestaServ.buscarMiListaProd(miUsu.getDniusu());
		
		Productos miProd;
		
		ArrayList <Productos> listaProd = new ArrayList <Productos> ();
		
		for (Cesta cesta : miCestaCompleta) {
			
			miProd = productosServicio.buscarProd(cesta.getCestaPK().getCodproducto());
			listaProd.add(miProd);
		}
		
		modelo.addAttribute("listaProd", listaProd);
		
		modelo.addAttribute("miCestaCompleta", miCestaCompleta);*/
		
		List <Vistacestacompleta> listaCesta = vistaCesServ.encuentraPorDNICesta(miUsu.getDniusu());
		
		modelo.addAttribute("listaCesta",listaCesta);
		
		modelo.addAttribute("miUsu",miUsu);
		
		return "cesta";
	}
	
	@GetMapping("/borraProdCesta")
	public String borraProd (Model modelo, HttpServletRequest request, HttpServletResponse response  ) {
		
		HttpSession miSesion = request.getSession();
		
		Usuario miUsu = (Usuario) miSesion.getAttribute("usuario");
		
		String dniUsu = miUsu.getDniusu();
		
		int codProd = Integer.parseInt(request.getParameter("codProd"));
		
		CestaPK cestaPK = new CestaPK(dniUsu,codProd);
		
		cestaServ.delete(cestaPK);
		
		List <Cesta> miCestaCompleta = cestaServ.buscarMiListaProd(dniUsu);
		
		int prodTotal=0;
		int precioTotal=0;
		
		for (Cesta cesta : miCestaCompleta) {
			prodTotal+= cesta.getUnidadesCesta();
			precioTotal += cesta.getTotalpreciocesta();
		}
		
		miSesion.setAttribute("prodTotal", prodTotal);
		miSesion.setAttribute("precioTotal", precioTotal);
		
		return "redirect:/irCesta";
	}
	
	@GetMapping("/actualizaProd")
	public String actualizamelo (Model modelo, HttpServletRequest request, HttpServletResponse response  ) {
		
		HttpSession miSesion = request.getSession();
		
		Usuario miUsu = (Usuario) miSesion.getAttribute("usuario");
		
		String dniUsu = miUsu.getDniusu();
		
		int codProd = Integer.parseInt(request.getParameter("codProd"));
		
		
		List <Cesta> miLC = cestaServ.buscarMiProd(dniUsu, codProd);
		
		Cesta miCesta = miLC.get(0);
		
		int precio = (int) Double.parseDouble(request.getParameter("precioProd"));
		
		String boton = request.getParameter("boton");
		
		if(boton.equals("minus bg-dark botonparacesta")) {
			miCesta.setUnidadesCesta(miCesta.getUnidadesCesta()-1);
			
			miCesta.setTotalpreciocesta(miCesta.getTotalpreciocesta()-precio);
		}else {
			miCesta.setUnidadesCesta(miCesta.getUnidadesCesta()+1);
			
			miCesta.setTotalpreciocesta(miCesta.getTotalpreciocesta()+precio);
		}
		
		
		
		List <Cesta> miCestaCompleta = cestaServ.buscarMiListaProd(dniUsu);
		
		int prodTotal=0;
		int precioTotal=0;
		
		for (Cesta cesta : miCestaCompleta) {
			prodTotal+= cesta.getUnidadesCesta();
			precioTotal += cesta.getTotalpreciocesta();
		}
		
		miSesion.setAttribute("prodTotal", prodTotal);
		miSesion.setAttribute("precioTotal", precioTotal);
		
		
		
		cestaServ.save(miCesta);
		
		return "redirect:/irCesta";
	}
	
	@GetMapping("/confirmarCesta")
	public String confiramrCes (Model modelo, HttpServletRequest request, HttpServletResponse response  ) {
		
		HttpSession miSesion = request.getSession();
		
		Usuario miUsu = (Usuario) miSesion.getAttribute("usuario");
		
		String dniUsu = miUsu.getDniusu();
		
		int prods = (int) miSesion.getAttribute("prodTotal");
		
		int precio = (int)miSesion.getAttribute("precioTotal");
		
		Date fecha = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		String miFecha = sdf.format(fecha);
		
		Facturas miFact = new Facturas(null, dniUsu, prods, precio, miFecha);
		
		factsServ.save(miFact);
		
		List <Cesta> miCestaCompleta = cestaServ.buscarMiListaProd(dniUsu);
		
		for (Cesta cesta : miCestaCompleta) {
			
			int codProd = cesta.getCestaPK().getCodproducto();
			
			List<Cesta> miCesta = cestaServ.buscarMiProd(dniUsu, codProd);
			
			RegistroFactura miReg = new RegistroFactura(null,miFact.getCodFact(),cesta.getCestaPK().getCodproducto(),dniUsu,miCesta.get(0).getUnidadesCesta());
			
			registrServ.save(miReg);
		}
		
		Integer cf = miFact.getCodFact();
		
		int codigoFact =  cf.intValue();
		
		miSesion.setAttribute("codigoFact",codigoFact );
		
		for (Cesta cesta : miCestaCompleta) {
			int codProd = cesta.getCestaPK().getCodproducto();
			CestaPK cestaPK = new CestaPK(dniUsu,codProd);
			
			Productos prod = productosServicio.buscarProd(codProd);
			
				
			prod.setUnidadesProd(prod.getUnidadesProd()- cesta.getUnidadesCesta());
			
			productosServicio.save(prod);
			
			cestaServ.delete(cestaPK);
			
			PuntuacionesPK pklk = new PuntuacionesPK(codProd,dniUsu);
			
			Puntuaciones puntu = new Puntuaciones(pklk,0);
			
			puntuserv.save(puntu);
			
		}
		
		miSesion.setAttribute("prodTotal", 0);
		miSesion.setAttribute("precioTotal", 0);
		
		
		
		
		
		return "confirmado";
	}
	
	@GetMapping ("/cargaFactura")
	public String facturita (Model modelo, HttpServletRequest request, HttpServletResponse response  ) {
		
		HttpSession miSesion = request.getSession();
		
		Usuario miUsu = (Usuario) miSesion.getAttribute("usuario");
		
		String dniUsu = miUsu.getDniusu();
		
		List <Facturas> listaF = factsServ.buscaFactDNIFech(dniUsu);
		
		Facturas miFact = listaF.get(0);
		
		int codigoFact = miFact.getCodFact();
		
		//int codigoFact = (int) miSesion.getAttribute("codigoFact");
		
		List <Vistafacturacompleta> listaFactu  = visRegServ.encuentraPorDNIyCodFact(dniUsu,codigoFact);
		
		modelo.addAttribute("codFact", listaFactu.get(0).getCodFactura());
		
		modelo.addAttribute("fecha",  listaFactu.get(0).getFechafinal());
		
		//Integer codFact = Integer.valueOf(String.valueOf(miSesion.getAttribute("codigoFact")));
		
		//Facturas miFact = factsServ.buscaFactCod(codFact);
		
		
		
		modelo.addAttribute("miFact",miFact);
		
		modelo.addAttribute("listaFactu", listaFactu);
		
		return "factura";
	}
	
	@GetMapping("/enviaemail")
	public String enviarCorreo(Model modelo, HttpServletRequest request, HttpServletResponse response) {
		
		String email = request.getParameter("email");
		
		String origen = request.getParameter("origen");
		
		String contenido="";
        String root = sc.getRealPath("/");
        try(BufferedReader br = new BufferedReader(new FileReader(root+"WEB-INF\\email.html"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            contenido = sb.toString();
        } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		EmailUtils.enviarMail("smtp-mail.outlook.com", "587", "tallerarcustoms@outlook.com", "Ketegano2013", email, "Bienvenido a tu taller de confianza | Taller AR Customs", contenido);
		
		Date fecha = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		String miFecha = sdf.format(fecha);	
		
		Suscrip sus = new Suscrip(email,miFecha);
		
		susserv.save(sus);
		
		return "redirect:/"+origen;
	}
	
	@GetMapping("/cargaCita")
	public String cargaCitaa(Model modelo, HttpServletRequest request, HttpServletResponse response) {
		
		
		
		return "citas";
	}
	
	@GetMapping("/creaCita")
	public String creaCitaa(Model modelo, HttpServletRequest request, HttpServletResponse response) {
		HttpSession miSesion = request.getSession();
		
		Usuario miUsu = (Usuario) miSesion.getAttribute("usuario");
		
		String dniUsu = miUsu.getDniusu();
		
		String matr = request.getParameter("matr");
		
		String marca = request.getParameter("marca");
		
		String modeloXD= request.getParameter("modelo");
		
		String tipoCita = request.getParameter("tipoCita");
		
		String descrp = request.getParameter("descrp");
		
		String estado = "Recibido";
		
		Date fecha = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		String miFecha = sdf.format(fecha);	
		
		Citas miCita = new Citas(null,matr,marca,modeloXD,tipoCita,descrp,miFecha,estado,dniUsu);
		
		citasServ.save(miCita);
		
		miSesion.setAttribute("miCita", miCita);
		
		return "citas";
	}
	
	@GetMapping("/verEstadoCita")
	public String verEstado(Model modelo, HttpServletRequest request, HttpServletResponse response) {
		HttpSession miSesion = request.getSession();
		
		Usuario miUsu = (Usuario) miSesion.getAttribute("usuario");
		
		String dniUsu = miUsu.getDniusu();
		
		List<Citas> lc= citasServ.buscarMiCitaDNI(dniUsu);
		
		Citas miCita = lc.get(0);
		
		if(miCita!=null) {
			
		
		String estado = miCita.getEstadoCita();
		
		modelo.addAttribute("estado",estado);
		
		}
		
		else {
			modelo.addAttribute("noCita","noCita");
		}
		return "estadocita";
	}
	
	@GetMapping("/verCitasMec")
	public String vercitasMecanico(Model modelo, HttpServletRequest request, HttpServletResponse response) {
		
		List <Citas> listaCitas = citasServ.FindAll();
		
		modelo.addAttribute("listaCitas",listaCitas);
		
		return "meccitas";
	}
	
	@GetMapping("/actualizaEstado")
	public String actualizaC(Model modelo, HttpServletRequest request, HttpServletResponse response) {
		
		Integer codiguito = Integer.parseInt(request.getParameter("codiguito"));
		
		Citas miCita = citasServ.buscarMiCitaCod(codiguito);
		
		String estado = request.getParameter("estado");
		
		miCita.setEstadoCita(estado);
		
		citasServ.save(miCita);
		
		return "redirect:/verCitasMec";
	}
	
	@GetMapping("/actualizaParte")
	public String actualizaP(Model modelo, HttpServletRequest request, HttpServletResponse response) {
		
		Integer codiguito = Integer.parseInt(request.getParameter("codiguito"));
		
		Partes miParte = partesserv.buscarMiParteCod(codiguito);
		
		
		String estado = request.getParameter("estado");
		
		miParte.setEstadoParte(estado);
		
		partesserv.save(miParte);
		
		return "redirect:/verPartes";
	}
	
	
	@GetMapping("/verPartes")
	public String verpartesxd(Model modelo, HttpServletRequest request, HttpServletResponse response) {
		
		List <Partes> listaPartes = partesserv.FindAll();
		
		modelo.addAttribute("listaPartes", listaPartes);
		
		return "mecparte";
	}
	
	@GetMapping("/vercreaParte")
	public String vercrearelparte(Model modelo, HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession miSesion = request.getSession();
		
		String xc = request.getParameter("codCita");
		
		List <Citas> listacitas = citasServ.FindAll();
		
		
		if(xc!=null) {
			
			int codCita = Integer.parseInt(request.getParameter("codCita"));
			Citas miCita = citasServ.buscarMiCitaCod(codCita);
			
			miSesion.setAttribute("miCita",miCita);
		}
		
		modelo.addAttribute("listacitas",listacitas);
		
		
		List<Productos> listProductos = productosServicio.FindAll();
		
		String busca = request.getParameter("busca");
		
		if(busca!=null) {
			listProductos = productosServicio.buscarProductos(busca);
			modelo.addAttribute("buscado",busca);
		}else {
			listProductos = productosServicio.FindAll();
		}
		
		modelo.addAttribute("miListaProductos",listProductos);
		
		return "meccreaparte";
	}
	
	
	@GetMapping("/creaParte")
	public String crearelparte(Model modelo, HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession miSesion = request.getSession();
		
		Usuario miUsu = (Usuario) miSesion.getAttribute("usuario");
		
		String dniUsu = miUsu.getDniusu();
		
		Citas miCita = (Citas) miSesion.getAttribute("miCita");
		
		int utotal = (int) miSesion.getAttribute("prodTotal");
		int ptotal = (int) miSesion.getAttribute("precioTotal");
		
		Date fecha = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		String miFecha = sdf.format(fecha);
		
		List <Cesta> miCesta = cestaServ.buscarMiListaProd(dniUsu);
		
		String productos = "";
		
		for (Cesta cesta : miCesta) {
			productos+= cesta.getCestaPK().getCodproducto()+",";
			
			
		}
		
		productos = productos.substring(0, productos.length()-1);
		
		Partes miParte = new Partes (null,dniUsu,miCita.getMatricCoche(),ptotal,"en espera",miFecha,productos,miCita.getCodCita());
		
		partesserv.save(miParte);
		
		return "redirect:/verPartes";
	}
	
	@GetMapping("/verAdmin")
	public String verAdminxd(Model modelo, HttpServletRequest request, HttpServletResponse response) {
		
		List <Usuario> listaUsu = usuarioServicio.FindAll();
		
		modelo.addAttribute("listaUsu", listaUsu);
		
		return "adminUsu";
	}
	
	
	@GetMapping("/modifUsu")
	public String modifiUsu(Model modelo, HttpServletRequest request, HttpServletResponse response) {
		
		String dni = request.getParameter("dni");
		
		Usuario elusu = usuarioServicio.encuentradniUsu(dni);
		
		modelo.addAttribute("elusu", elusu);
		
		
		List <Usuario> listaUsu = usuarioServicio.FindAll();
		
		modelo.addAttribute("listaUsu", listaUsu);
		modelo.addAttribute("si", "si");
		
		return "adminUsu";
	}
	
	
	@GetMapping("/actualizaUsu")
	public String actuUsus(Model modelo, HttpServletRequest request, HttpServletResponse response) {
		
		String dni = request.getParameter("dni");
		
		String nombre = request.getParameter("nombre");
		
		String apell = request.getParameter("apell");
		
		String email = request.getParameter("email");
		
		String contra = request.getParameter("contra");
		
		String loca = request.getParameter("loca");
		
		String tipoUsu = request.getParameter("tipoUsu");
		
		Usuario nuevoUsu = new Usuario(dni,nombre,apell,email,contra,loca,tipoUsu);
		
		usuarioServicio.edit(nuevoUsu);
		
		return "redirect:/verAdmin";
	}
	
	@GetMapping("/eliminUsu")
	public String elimniaUSu(Model modelo, HttpServletRequest request, HttpServletResponse response) {
		
		String dni = request.getParameter("dni");
		
		usuarioServicio.delete(dni);
		
		return "redirect:/verAdmin";
	}
	
	
	
	@GetMapping("/irAdminCitas")
	public String adminCita(Model modelo, HttpServletRequest request, HttpServletResponse response) {
		
		List <Citas> listCitas = citasServ.FindAll();
		
		List <Partes> listPart = partesserv.FindAll();

		
		modelo.addAttribute("listCitas",listCitas);
		
		modelo.addAttribute("listPart",listPart);
		
		return "adminCitas";
	}
	
	@GetMapping("/modifCita")
	public String modCita(Model modelo, HttpServletRequest request, HttpServletResponse response) {
		
		Integer cod = Integer.parseInt(request.getParameter("cod"));
		
		Citas lacita = citasServ.buscarMiCitaCod(cod);
		
		List <Citas> listCitas = citasServ.FindAll();

		List <Partes> listPart = partesserv.FindAll();
		
		modelo.addAttribute("lacita",lacita);
		
		modelo.addAttribute("listCitas",listCitas);
		
		modelo.addAttribute("listPart",listPart);
		
		modelo.addAttribute("si", "si");
		
		return "adminCitas";
	}
	
	@GetMapping("/actuCita")
	public String actCita(Model modelo, HttpServletRequest request, HttpServletResponse response) {
	
		Integer cod = Integer.parseInt(request.getParameter("Cod"));
		
		String Matricula = request.getParameter("Matricula");
		
		String Marca = request.getParameter("Marca");
		
		String Modelo = request.getParameter("Modelo");
		
		String descrp = request.getParameter("descrp");
		
		String Fecha = request.getParameter("Fecha");
		
		String DNI = request.getParameter("DNI");
		
		String tipoCit = request.getParameter("tipoCit");
		
		String estadoCita = request.getParameter("estadoCita");
		
		Citas miCita = new Citas(cod,Matricula,Marca,Modelo,tipoCit,descrp,Fecha,estadoCita,DNI);
	
		citasServ.edit(miCita);
		
		return "redirect:/irAdminCitas";
	}
	
	@GetMapping("/borracita")
	public String borrcit(Model modelo, HttpServletRequest request, HttpServletResponse response) {
		Integer cod = Integer.parseInt(request.getParameter("cod"));
		
		citasServ.delete(cod);
		
		return "redirect:/irAdminCitas";
	}
	
	@GetMapping("/modifParte")
	public String modpart(Model modelo, HttpServletRequest request, HttpServletResponse response) {
		
		Integer cod = Integer.parseInt(request.getParameter("codP"));
		
		Partes elparte = partesserv.buscarMiParteCod(cod);
		
		List <Citas> listCitas = citasServ.FindAll();

		List <Partes> listPart = partesserv.FindAll();
		
		modelo.addAttribute("elparte",elparte);
		
		modelo.addAttribute("listCitas",listCitas);
		
		modelo.addAttribute("listPart",listPart);
		
		modelo.addAttribute("si", "si");
		
		return "adminCitas";
	}
	
	
	@GetMapping("/actuParte")
	public String actuPartes(Model modelo, HttpServletRequest request, HttpServletResponse response) {
	
		Integer cod = Integer.parseInt(request.getParameter("codP"));
		
		String mec = request.getParameter("mec");
		
		String matr = request.getParameter("matr");
		
		int coste =Integer.parseInt(request.getParameter("coste"));
		
		String fech = request.getParameter("fech");
		
		String prods = request.getParameter("prods");
		
		int cita = Integer.parseInt(request.getParameter("cita"));
		
		String estad = request.getParameter("estad");
		
		Partes miParte = new Partes(cod,mec,matr,coste,estad,fech,prods,cita);
		
		partesserv.save(miParte);
		
		return "redirect:/irAdminCitas";
	}
	
	
	@GetMapping("/borraparte")
	public String borrPart(Model modelo, HttpServletRequest request, HttpServletResponse response) {
		Integer cod = Integer.parseInt(request.getParameter("codP"));
		
		partesserv.delete(cod);
		
		return "redirect:/irAdminCitas";
	}
	
	
	@GetMapping("/irAdminProd")
	public String adminProd(Model modelo, HttpServletRequest request, HttpServletResponse response) {
		
		List<Productos> listProductos = productosServicio.FindAll();
		
		modelo.addAttribute("listProductos",listProductos);
		
		return "adminProd";
	}
	
	@GetMapping("/irAdminEsta")
	public String adminEsta(Model modelo, HttpServletRequest request, HttpServletResponse response) {
		
		List<Productos> listProductos = productosServicio.FindAll();
		
		JSONObject jsonprod = new JSONObject();
		
		JSONObject jsonprodCompleto = new JSONObject();
		
		
		for (Productos productos : listProductos) {
			jsonprod.put("codProd", productos.getCodProd());
			jsonprod.put("nomProd", productos.getNomProd());
			jsonprod.put("imgProd", productos.getImgProd());
			jsonprod.put("desProd", productos.getDescripProd());
			jsonprod.put("uniProd", productos.getUnidadesProd());
			jsonprod.put("punProd", productos.getPuntuacionProd());
			jsonprod.put("fecProd", productos.getFechaProd());
			jsonprod.put("precProd", productos.getPrecioProd());
			jsonprod.put("cateProd", productos.getCategoriaProd());
			
			jsonprodCompleto.put(String.valueOf(productos.getCodProd()), jsonprod);
			
			jsonprod = new JSONObject();
			
		}
		
		response.setContentType("aplication/json");
		modelo.addAttribute("listProductos",jsonprodCompleto.toString());
		
		try {
			response.getWriter().print(jsonprodCompleto.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return "adminEsta";
	}
	
	@GetMapping("/modifProd")
	public String modifaProd(Model modelo, HttpServletRequest request, HttpServletResponse response) {
		
		Integer cod = Integer.parseInt(request.getParameter("codProd"));
		
		List <Productos> lp = productosServicio.buscarMiProd(cod);
		
		Productos elprod = lp.get(0);
		
		modelo.addAttribute("elprod",elprod);
		
		List<Productos> listProductos = productosServicio.FindAll();
		
		modelo.addAttribute("listProductos",listProductos);
		modelo.addAttribute("si", "si");
		
		return "adminProd";
	}
	
	
	@GetMapping("/borraProd")
	public String borrProduduc(Model modelo, HttpServletRequest request, HttpServletResponse response) {
		Integer cod = Integer.parseInt(request.getParameter("codProd"));
		
		productosServicio.delete(cod);
		
		return "redirect:/irAdminCitas";
	}
	
	
	@GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename){
        Resource file= ss.loadAsResource(filename);
        return ResponseEntity.ok().body(file);
    }
	
	
	@PostMapping("/actualizaProd")
	public String actualizaProd(@RequestParam("subir") MultipartFile file,HttpServletRequest request) {
		
		if(!file.isEmpty()) {
			
			
	        
			String nombreImg="";
			
			try {
                Collection<Part> col=request.getParts();
                for(Part p:col){
                        if(p.getSubmittedFileName()!=null) {
                            nombreImg=p.getSubmittedFileName();
                            System.out.println(p.getSubmittedFileName());
                        }
                }

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ServletException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
			
			String imagen = ss.store(file, nombreImg);
			
			Integer codProd = Integer.parseInt(request.getParameter("codProd"));
			
			String nomProd = request.getParameter("nomProd");
			
			String categoriaProd = request.getParameter("categoriaProd");
			
			String descripProd = request.getParameter("descripProd");
			
			int unidadesProd = Integer.parseInt(request.getParameter("unidadesProd"));
			
			double precioProd = Double.parseDouble(request.getParameter("unidadesProd"));
			
			int puntuacionProd = Integer.parseInt(request.getParameter("unidadesProd"));
			
			//String fechaProd = request.getParameter("fechaProd");
			
			Date fechaProd = new Date();
			
			Productos producto = new Productos(codProd,nomProd,categoriaProd,imagen,descripProd,unidadesProd,precioProd,puntuacionProd,fechaProd);
			
			producto.setImgProd(imagen);
			
			productosServicio.save(producto);
			
				
		}
		
		
		return "redirect:/irAdminProd";
	}
	
	@GetMapping("/cargaPuntu")
	public String cargaPuntuxd(Model modelo, HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession miSesion = request.getSession();
		
		Usuario miUsu = (Usuario) miSesion.getAttribute("usuario");
		
		String dniUsu = miUsu.getDniusu();
		
		
		List <Puntuaciones> listaPuntu = puntuserv.buscamiPuntu(dniUsu);
		
		List <Vistapuntuaciones>lvs = vps.buscaPuntuDNI(dniUsu);
		
		modelo.addAttribute("lvs", lvs);
		
		return "puntuaciones";
	}
	
	
	@GetMapping("/actualizaPuntu")
	public String actualizaPuntus(Model modelo, HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession miSesion = request.getSession();
		
		Usuario miUsu = (Usuario) miSesion.getAttribute("usuario");
		
		String dniUsu = miUsu.getDniusu();
		
		Integer cod  = Integer.parseInt(request.getParameter("codigoProducto"));
		
		int nuevaPuntu = Integer.parseInt(request.getParameter("nuevaPunt"));
		
		PuntuacionesPK ppk = new PuntuacionesPK(cod,dniUsu);
		
		Puntuaciones puntu = new Puntuaciones(ppk,nuevaPuntu);
		
		puntuserv.save(puntu);
		
		
		Productos miProd = productosServicio.buscarProd(cod);
		
		int puntuOld = miProd.getPuntuacionProd();
		
		List <Puntuaciones> lp = puntuserv.buscamiPuntuCo(cod);
		
		int cantidadPuntuaciones = lp.size();
		
		
		
		return "redirect:/cargaPuntu";
	}
	
	
	@GetMapping("/verAdminFacts")
	public String verAdminFactsd(Model modelo, HttpServletRequest request, HttpServletResponse response) {
		
		List <Facturas> lf = factsServ.FindAll();
		
		JSONObject jsonprod = new JSONObject();
		
		JSONObject jsonprodCompleto = new JSONObject();
		
		
		
		for (Facturas fact : lf) {
			jsonprod.put("codFact", fact.getCodFact());
			jsonprod.put("dniCli", fact.getDniCli());
			jsonprod.put("uniTot", fact.getUnidadestotal());
			jsonprod.put("precTot", fact.getPreciototal());
			jsonprod.put("fech", fact.getFechafinal());
			
			jsonprodCompleto.put(String.valueOf(fact.getCodFact()), jsonprod);
			
			jsonprod = new JSONObject();
			
		}
		
		response.setContentType("aplication/json");
		modelo.addAttribute("jsonprodCompleto",jsonprodCompleto.toString());
		
		try {
			response.getWriter().print(jsonprodCompleto.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return "adminFact";
	}
	
	
	@GetMapping("/generarPDF")
	public String generarFacturaPDF(HttpServletRequest request) {
		
			HttpSession miSesion = request.getSession();
		
			Usuario miUsu = (Usuario) miSesion.getAttribute("usuario");
			
			String dniUsu = miUsu.getDniusu();
			
			List <Facturas> listaF = factsServ.buscaFactDNIFech(dniUsu);
			
			Facturas miFact = listaF.get(0);
			
			int codigoFact = miFact.getCodFact();
	
			File pdfNewFile = new File("src/main/webapp/pdfs/Factura nº "+codigoFact+" del cliente "+miUsu.getNombreusu()+" "+miUsu.getApellusu()+".pdf");
			
			Document document = new Document();
			
			try {
				PdfWriter.getInstance(document, new FileOutputStream(pdfNewFile));
			} catch (FileNotFoundException | DocumentException e) {
				e.printStackTrace();
			}
			
			document.open();
	        
	        document.addTitle("Factura Taller AR Customs de "+miUsu.getNombreusu()+" "+miUsu.getApellusu());
	        document.addSubject("(usando iText)");
	        document.addKeywords("Java, PDF, iText");
	        document.addAuthor("Alejandro Rojas");
	        document.addCreator("Alejandro Rojas");
	        
	        Chunk chunk = new Chunk("Este PDF ha sido generado con java");
			
	         PdfPTable table = new PdfPTable(5);
	         table.setWidthPercentage(95);
	         Image imagen;
	         
			try {
				
				imagen = Image.getInstance("src/main/webapp/img/logotipopdf.png");
				
				table.addCell(imagen);
				
			} catch (BadElementException e) {
				
			} catch (MalformedURLException e) {
				
			} catch (IOException e) {
				
			}
			
			PdfPCell cnumfact = new PdfPCell(new Paragraph("Factura nº: "+codigoFact));
			cnumfact.setColspan(2);
			cnumfact.setPadding(10);
			table.addCell(cnumfact);
			
			String mensaje="Buenas "+miUsu.getNombreusu()+" "+miUsu.getApellusu()+", esta es tu factura del día "+miFact.getFechafinal();
			
			PdfPCell cdet = new PdfPCell(new Paragraph(mensaje));
			cdet.setColspan(5); 
			cdet.setPadding(10);
			table.addCell(cdet);
			
			PdfPCell cmensaje = new PdfPCell(new Paragraph("Detalles de la factura:"));
			cmensaje.setColspan(5); 
			table.addCell(cmensaje);
			
			
			PdfPTable table2 = new PdfPTable(2);
		
			BaseColor color = WebColors.getRGBColor("#AEFFD6");
			
			PdfPCell cfecha = new PdfPCell(new Paragraph("Fecha factura generada:"+miFact.getFechafinal()));
			cfecha.setBorder(0);
			cfecha.setBackgroundColor(color);
			table2.addCell(cfecha);
			
			PdfPCell ccod = new PdfPCell(new Paragraph("Número de pedido: "+miFact.getCodFact() ));
			ccod.setBorder(0);
			ccod.setBackgroundColor(color);
			table2.addCell(ccod);
		
			
			PdfPCell ccorreo = new PdfPCell(new Paragraph("Correo: "+miUsu.getEmailusu()));
			ccorreo.setBorder(0);
			ccorreo.setBackgroundColor(color);
			table2.addCell(ccorreo);
							
			PdfPCell cdni = new PdfPCell(new Paragraph("DNI: "+miUsu.getDniusu()));
			cdni.setBorder(0);
			cdni.setBackgroundColor(color);
			table2.addCell(cdni);
			
			PdfPCell cdatos = new PdfPCell(table2);
			cdatos.setColspan(5);
			cdatos.setPadding(10);
			table.addCell(cdatos);
				
			PdfPCell celdaSumario = new PdfPCell(new Paragraph("Sumario: Has comprado "+miFact.getUnidadestotal()+ " productos, un total de  "+miFact.getPreciototal()+" $"));
			celdaSumario.setColspan(5); 
			celdaSumario.setPadding(10);
			table.addCell(celdaSumario);
				
				
					 
			 PdfPCell cprod = new PdfPCell(new Paragraph("Tus productos son:"));
			 cprod.setColspan(5);
			 cprod.setPadding(3);
			 table.addCell(cprod);
			
			 PdfPTable tableArticulos= new PdfPTable(5);
				 
			 PdfPCell cprod2 = new PdfPCell(new Paragraph("Código Prod"));
			 cprod2.setPadding(10);
			 cprod2.setBackgroundColor(color);
			 cprod2.setBorder(0);
			 tableArticulos.addCell(cprod2);
			 
			 PdfPCell cimg = new PdfPCell(new Paragraph("Imagen"));
			 cimg.setPadding(10);
			 cimg.setBackgroundColor(color);
			 cimg.setBorder(0);
			 tableArticulos.addCell(cimg);
			 
			 PdfPCell cnomprod = new PdfPCell(new Paragraph("Producto"));
			 cnomprod.setPadding(10);
			 cnomprod.setBackgroundColor(color);
			 cnomprod.setBorder(0);
			 tableArticulos.addCell(cnomprod);
			 
			 PdfPCell cprecioprod = new PdfPCell(new Paragraph("Precio"));
			 cprecioprod.setPadding(10);
			 cprecioprod.setBackgroundColor(color);
			 cprecioprod.setBorder(0);
			 tableArticulos.addCell(cprecioprod);
			 
			 PdfPCell ctotalprod = new PdfPCell(new Paragraph("Total"));
			 ctotalprod.setPadding(10);
			 ctotalprod.setBackgroundColor(color);
			 ctotalprod.setBorder(0);
			 tableArticulos.addCell(ctotalprod);
		 
			 
			 List <RegistroFactura> miRegistro = registrServ.buscaReg(codigoFact);
			 
			 for(int i=0;i<miRegistro.size();i++) {
			 
				 int codProd=miRegistro.get(i).getCodProducto();
				
				 Productos producto = productosServicio.buscarProd(codProd);
				 
				 RegistroFactura registroFac = registrServ.buscaRegCompleta(codigoFact, codProd, dniUsu);
				 
				 PdfPCell celdaCodArt = new PdfPCell(new Paragraph(producto.getCodProd()+" "));
				 celdaCodArt.setPadding(10);
				 tableArticulos.addCell(celdaCodArt);
				 
				Image icono;
				try {
					icono = Image.getInstance("src/main/webapp/img/prod/"+producto.getImgProd());
					tableArticulos.addCell(icono);
				} catch (BadElementException | IOException e1) {
					e1.printStackTrace();
				}
				 
				 
				 PdfPCell celdaNombre = new PdfPCell(new Paragraph(producto.getNomProd()));
				 celdaNombre.setPadding(10);
				 tableArticulos.addCell(celdaNombre);
				 
				 PdfPCell celdaPrecio = new PdfPCell(new Paragraph(producto.getPrecioProd()+" €"));
				 celdaPrecio.setPadding(10);
				 tableArticulos.addCell(celdaPrecio);
				 
				 PdfPCell celdaTotal = new PdfPCell(new Paragraph(registroFac.getTotalUnidades()+" "));
				 celdaTotal.setPadding(10);
				 tableArticulos.addCell(celdaTotal);
				 
			 }
		 
			 PdfPCell celdaTablaArt = new PdfPCell(tableArticulos);
			 celdaTablaArt.setColspan(5);
			 celdaTablaArt.setPadding(10);
			 table.addCell(celdaTablaArt);
					 
			try {
				document.add(table);
				document.close();
			} catch (DocumentException e) {
				e.printStackTrace();
			}
	        
	        return "redirect:/irInicio";
		}
	
	
}
