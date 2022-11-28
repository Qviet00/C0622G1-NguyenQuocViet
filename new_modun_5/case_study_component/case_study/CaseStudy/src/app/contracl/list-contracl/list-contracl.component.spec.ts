import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListContraclComponent } from './list-contracl.component';

describe('ListContraclComponent', () => {
  let component: ListContraclComponent;
  let fixture: ComponentFixture<ListContraclComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListContraclComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListContraclComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
