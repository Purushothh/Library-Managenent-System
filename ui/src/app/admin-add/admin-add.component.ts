import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {FormControl, FormGroup} from "@angular/forms";
import {FormSubmitService} from "../form-submit.service";

@Component({
  selector: 'app-admin-add',
  templateUrl: './admin-add.component.html',
  styleUrls: ['./admin-add.component.css']
})
export class AdminAddComponent  {
  form:FormGroup;
  name: string;

  constructor(private http: HttpClient, private formSubmitService: FormSubmitService) {
    this.form = new FormGroup({
      'number': new FormControl(null),
      'title': new FormControl(null),
      'itemSector': new FormControl(null),
      'itemPbDate': new FormControl(null),
      'Author': new FormControl(null),
      'Publisher': new FormControl(null),
      'itemPages': new FormControl(null)
    });
  }




  onAction() {

    let variableName = JSON.stringify(this.form.value);
    this.formSubmitService.sendName(variableName).subscribe((resp:string) => {
      this.name = resp;
    });

  }

/*
  onAction() {
    let variableName = JSON.stringify(this.form.value);
    return this.http.post('/api/onclick', variableName).subscribe((test1: any) => {
      console.log(test1);

    });
  }*/
}
