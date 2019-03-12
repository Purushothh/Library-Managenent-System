import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminBorrowComponent } from './admin-borrow.component';

describe('AdminBorrowComponent', () => {
  let component: AdminBorrowComponent;
  let fixture: ComponentFixture<AdminBorrowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminBorrowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminBorrowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
