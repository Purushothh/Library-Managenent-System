import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {FormControl, FormGroup} from "@angular/forms";
import {FormSubmitService} from "../form-submit.service";

@Component({
  selector: 'app-add-reader',
  templateUrl: './add-reader.component.html',
  styleUrls: ['./add-reader.component.css']
})
export class AddReaderComponent {

  form:FormGroup;
  name: string;


  constructor(private http: HttpClient, private formSubmitService: FormSubmitService) {
    this.form = new FormGroup({
      'RID': new FormControl(null),
      'readerName': new FormControl(null),
      'TelNo': new FormControl(null),
      'Email': new FormControl(null)
    });
  }


  onActionReader () {

    let variableName = JSON.stringify(this.form.value);
    return this.http.post('/api/onclickReader ', variableName).subscribe((resp:string) => {
      this.name = resp;
    });
  }





}
