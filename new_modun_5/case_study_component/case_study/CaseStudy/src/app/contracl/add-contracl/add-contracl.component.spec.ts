import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddContraclComponent } from './add-contracl.component';

describe('AddContraclComponent', () => {
  let component: AddContraclComponent;
  let fixture: ComponentFixture<AddContraclComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddContraclComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddContraclComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
