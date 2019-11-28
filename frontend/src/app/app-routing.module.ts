import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


import { CalendarioComponent } from './views/calendario';
import { LoginComponent } from './views/login';
import { MateriaComponent} from './views/materia';
import { NotaComponent} from './views/nota';
import { RegistroComponent } from './views/registro';

export const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'app', component: CalendarioComponent },
  { path: 'materia', component: MateriaComponent },
  { path: 'nota', component: NotaComponent },
  { path: 'registro', component: RegistroComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})

export class AppRoutingModule {}
