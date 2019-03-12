import { Component,  } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-admin-display',
  templateUrl: './admin-display.component.html',
  styleUrls: ['./admin-display.component.css']
})
export class AdminDisplayComponent  {

  form:FormGroup;

  constructor(private http: HttpClient) {
    this.form = new FormGroup({
      'number': new FormControl(null),

    });
  }


  onActionDisplay() {

    let variableName = JSON.stringify(this.form.value);
    return this.http.post('/api/onActionAddDVD', variableName).subscribe((test2: any) => {
      console.log(test2);
    });
  }



}
