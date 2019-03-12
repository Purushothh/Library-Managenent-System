import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HTTP_INTERCEPTORS, HttpClientModule, HttpClientXsrfModule } from '@angular/common/http';
import {ReactiveFormsModule} from '@angular/forms';

import { AppComponent } from './app.component';
import { RouteExampleComponent } from './route-example/route-example.component';


import { AppService } from './app.service';
import { AppHttpInterceptorService } from './http-interceptor.service';
import { AddItemComponent } from './add-item/add-item.component';
import { AdminComponent } from './admin/admin.component';
import { AdminAddComponent } from './admin-add/admin-add.component';
import { AdminBorrowComponent } from './admin-borrow/admin-borrow.component';
import { AdminDeleteComponent } from './admin-delete/admin-delete.component';
import { AdminDisplayComponent } from './admin-display/admin-display.component';
import { AdminGenerateComponent } from './admin-generate/admin-generate.component';
import { AdminReturnComponent } from './admin-return/admin-return.component';
import { GenerateComponent } from './generate/generate.component';
import { HomeComponent } from './home/home.component';
import { ManagerComponent } from './manager/manager.component';
import { ReaderComponent } from './reader/reader.component';
import { ReaderNavComponent } from './reader-nav/reader-nav.component';
import { TemplateDrivenComponent } from './template-driven/template-driven.component';
import { TemplateDrivenReaderComponent } from './template-driven-reader/template-driven-reader.component';
import {FormsModule} from "@angular/forms";
import { AppRoutingModule } from './/app-routing.module';
import {FormSubmitService} from "./form-submit.service";
import { AdminAddDvdComponent } from './admin-add-dvd/admin-add-dvd.component';
import { AddReaderComponent } from './add-reader/add-reader.component';

const routes: Routes = [
  {
    path: 'java',
    component: RouteExampleComponent,
    data: { technology: 'Java' }
  },
  {
    path: 'play',
    component: RouteExampleComponent,
    data: { technology: 'Play' }
  },
  {
    path: 'angular',
    component: RouteExampleComponent,
    data: { technology: 'Angular' }
  },
  {
    path: '**',
    redirectTo: '/play',
    pathMatch: 'full'
  }
];

@NgModule({
  declarations: [
    AppComponent,
    RouteExampleComponent,
    AddItemComponent,
    AdminComponent,
    AdminAddComponent,
    AdminBorrowComponent,
    AdminDeleteComponent,
    AdminDisplayComponent,
    AdminGenerateComponent,
    AdminReturnComponent,
    GenerateComponent,
    HomeComponent,
    ManagerComponent,
    ReaderComponent,
    ReaderNavComponent,
    TemplateDrivenComponent,
    TemplateDrivenReaderComponent,
    AdminAddDvdComponent,
    AddReaderComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    HttpClientXsrfModule.withOptions({
      cookieName: 'Csrf-Token',
      headerName: 'Csrf-Token',
    }),
    RouterModule.forRoot(routes),
    AppRoutingModule,
  ],
  providers: [
    AppService,
    {
      multi: true,
      provide: HTTP_INTERCEPTORS,
      useClass: AppHttpInterceptorService
    },
    FormSubmitService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
