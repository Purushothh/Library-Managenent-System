import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {FormControl, FormGroup} from "@angular/forms";
import {FormSubmitService} from "../form-submit.service";

@Component({
  selector: 'app-admin-add-dvd',
  templateUrl: './admin-add-dvd.component.html',
  styleUrls: ['./admin-add-dvd.component.css']
})
export class AdminAddDvdComponent  {
  form:FormGroup;
  name: string;

  constructor(private http: HttpClient, private formSubmitService: FormSubmitService) {
    this.form = new FormGroup({
      'number': new FormControl(null),
      'title': new FormControl(null),
      'itemSector': new FormControl(null),
      'languages': new FormControl(null),
      'subtitles': new FormControl(null),
      'itemPbdDate': new FormControl(null),
      'Producer': new FormControl(null),
      'Actor': new FormControl(null)
    });
  }




  onActionAddDVD() {

    let variableName = JSON.stringify(this.form.value);
    return this.http.post('/api/onclickDVD ', variableName).subscribe((resp:string) => {
      this.name = resp;
    });
  }



}
