import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PruebaNgModelComponent } from './prueba-ng-model.component';

describe('PruebaNgModelComponent', () => {
  let component: PruebaNgModelComponent;
  let fixture: ComponentFixture<PruebaNgModelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PruebaNgModelComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PruebaNgModelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
