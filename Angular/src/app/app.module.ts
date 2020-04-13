import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { DataTablesModule } from 'angular-datatables';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { JoyListComponent } from './joy-list/joy-list.component';
import { AddJoyComponent } from './add-joy/add-joy.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    JoyListComponent,
    AddJoyComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule,
    DataTablesModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }