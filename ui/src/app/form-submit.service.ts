import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {catchError} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class FormSubmitService {

  constructor(private http: HttpClient) { }

  public sendName(name: any) {
    return this.http.post('/api/onclick', name).pipe(
      catchError(this.handleError())
    );
  }

  handleError(): any {

  }
}
