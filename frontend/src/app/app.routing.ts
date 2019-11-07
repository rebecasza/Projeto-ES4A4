import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

// Import Containers
import {
  LoginComponent,
  FullLayoutComponent
} from './containers';

export const routes: Routes = [
  {
    path: 'home',
    component: FullLayoutComponent,
          data: {
        title: 'Home'
    },
  },
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
    },
  }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
