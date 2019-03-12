import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TemplateDrivenReaderComponent } from './template-driven-reader.component';

describe('TemplateDrivenReaderComponent', () => {
  let component: TemplateDrivenReaderComponent;
  let fixture: ComponentFixture<TemplateDrivenReaderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TemplateDrivenReaderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TemplateDrivenReaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
