import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TablaObjetoComponent } from './tabla-objeto.component';

describe('TablaObjetoComponent', () => {
  let component: TablaObjetoComponent;
  let fixture: ComponentFixture<TablaObjetoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TablaObjetoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TablaObjetoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
