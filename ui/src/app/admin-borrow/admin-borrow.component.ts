import {Component} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-admin-borrow',
  templateUrl: './admin-borrow.component.html',
  styleUrls: ['./admin-borrow.component.css']
})
export class AdminBorrowComponent {
  form: FormGroup;
  availableStatus: string;


  constructor(private http: HttpClient) {
    this.form = new FormGroup({
      'number': new FormControl(null),
      'ReaderId': new FormControl(null),
      'BDate': new FormControl(null),
      'BTime': new FormControl(null)
      // 'RTime': new FormControl(null)

    });
  }

  onActionBorrow() {

    let variableName = JSON.stringify(this.form.value);
    return this.http.post('/api/onActionBorrow', variableName).subscribe((test1: string) => {
      this.availableStatus = test1;
    });
  }
}



