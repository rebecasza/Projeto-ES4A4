import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


import { CalendarioComponent } from './views/calendario';
import { LoginComponent } from './views/login';
import { MateriaComponent} from './views/materia';
import { NotaComponent} from './views/nota';
import { RegistroComponent } from './views/registro';
import { PlanejamentoComponent } from './views/planejamento/planejamento.component';

export const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'app', component: CalendarioComponent },
  { path: 'materia', component: MateriaComponent },
  { path: 'edit/:materiasId', component: MateriaComponent },
  { path: 'nota', component: NotaComponent },
  { path: 'registro', component: RegistroComponent },
  { path: 'planejamento', component: PlanejamentoComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})

export class AppRoutingModule {}
