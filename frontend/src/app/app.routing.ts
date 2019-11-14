import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

// Import Containers
import {
  FullLayoutComponent
} from './containers';

import { LoginComponent } from '../app/views/login';
import { MateriaComponent} from '../app/views/materia';
import { NotaComponent} from '../app/views/nota';

export const routes: Routes = [
  {
    path: '',
    component: LoginComponent,
    data: {
      title: 'Home'
    }
  },
  {
      path: 'app',
      component: FullLayoutComponent,
      data: {
        title: 'Home'
    }
  },
  {
    path: 'materia',
    component: MateriaComponent,
    data: {
      title: 'Home'
    }
  },
  {
    path: 'nota',
    component: NotaComponent,
    data: {
      title: 'Home'
  }
}
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})

export class AppRoutingModule {}
