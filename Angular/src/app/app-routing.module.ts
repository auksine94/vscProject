import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { JoyListComponent } from './joy-list/joy-list.component';
import { AddJoyComponent } from './add-joy/add-joy.component';

const routes: Routes = [
  { path: '', redirectTo: 'list-joy', pathMatch: 'full' },
  { path: 'list-joy', component: JoyListComponent },
  { path: 'add-joy', component: AddJoyComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }