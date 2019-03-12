import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAddDvdComponent } from './admin-add-dvd.component';

describe('AdminAddDvdComponent', () => {
  let component: AdminAddDvdComponent;
  let fixture: ComponentFixture<AdminAddDvdComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminAddDvdComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminAddDvdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
