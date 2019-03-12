import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-admin-delete',
  templateUrl: './admin-delete.component.html',
  styleUrls: ['./admin-delete.component.css']
})
export class AdminDeleteComponent {
  form:FormGroup;
  name: string;

  constructor(private http: HttpClient) {
    this.form = new FormGroup({
      'number': new FormControl(null),

    });
  }

  onActionDelete() {

    let variableName = JSON.stringify(this.form.value);
    return this.http.post('/api/onclickDelete', variableName).subscribe((resp: string) => {
      this.name=resp;
    });
  }

}
