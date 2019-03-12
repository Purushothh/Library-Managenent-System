import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-admin-return',
  templateUrl: './admin-return.component.html',
  styleUrls: ['./admin-return.component.css']
})
export class AdminReturnComponent implements OnInit {

  form: FormGroup;
  itemDetails: string;
  fineDetails: string;

  constructor(private http:HttpClient) {
    this.form = new FormGroup({
      'isbn' : new FormControl(null),
      'returnDate' : new FormControl(null)
    });
  }

  ngOnInit() {
  }

  onReturn() {
    this.http.post('/api/onReturn', JSON.stringify(this.form.value)).subscribe((resp:any) => {
      this.fineDetails = resp;
    });
  }

}
