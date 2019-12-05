import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlanejamentoComponent } from './planejamento.component';

describe('PlanejamentoComponent', () => {
  let component: PlanejamentoComponent;
  let fixture: ComponentFixture<PlanejamentoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlanejamentoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlanejamentoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
