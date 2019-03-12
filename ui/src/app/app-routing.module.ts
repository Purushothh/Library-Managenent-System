import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';


import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { TemplateDrivenComponent } from './template-driven/template-driven.component';
import {AdminComponent} from './admin/admin.component';
import { ReaderComponent } from './reader/reader.component';
import { ReaderNavComponent } from './reader-nav/reader-nav.component';
import { AddItemComponent } from './add-item/add-item.component';
import { AdminAddComponent } from './admin-add/admin-add.component';
import { AdminDeleteComponent } from './admin-delete/admin-delete.component';
import { AdminDisplayComponent } from './admin-display/admin-display.component';
import { AdminBorrowComponent } from './admin-borrow/admin-borrow.component';
import { AdminReturnComponent } from './admin-return/admin-return.component';
import { AdminGenerateComponent } from './admin-generate/admin-generate.component';
import {AdminAddDvdComponent} from "./admin-add-dvd/admin-add-dvd.component";
import {AddReaderComponent} from "./add-reader/add-reader.component";



const routes: Routes = [
  {path: 'home',component: HomeComponent},
  {path: "temp", component : TemplateDrivenComponent},
  {path: "admin", component: AdminComponent},
  {path: "reader", component: ReaderComponent},
  {path: 'readerNav', component:ReaderNavComponent},
  {path: 'add',component: AddItemComponent},
  {path:'adminAdd',component:AdminAddComponent},
  {path:'adminDelete',component:AdminDeleteComponent},
  {path:'adminAddDVD', component:AdminAddDvdComponent},
  {path:'adminDisplay',component:AdminDisplayComponent},
  {path:'adminBorrow',component:AdminBorrowComponent},
  {path:'adminReturn',component:AdminReturnComponent},
  {path:'adminBorrow',component:AdminBorrowComponent},
  {path:'adminGenerate',component:AdminGenerateComponent},
  {path:'adminAddReader',component:AddReaderComponent}
];


@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule],
  declarations: []
})
export class AppRoutingModule { }
