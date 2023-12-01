import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarObjetoComponent } from './listar-objeto.component';

describe('ListarObjetoComponent', () => {
  let component: ListarObjetoComponent;
  let fixture: ComponentFixture<ListarObjetoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListarObjetoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarObjetoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
