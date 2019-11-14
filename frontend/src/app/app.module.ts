import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { HttpModule } from '@angular/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppAsideModule, AppSidebarModule, AppBreadcrumbModule } from '@coreui/angular';
import { CalendarModule } from 'angular-calendar';
import { FullCalendarModule } from '@fullcalendar/angular';
import { AvatarModule } from 'ng2-avatar';

// Import 3rd party components
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { TabsModule } from 'ngx-bootstrap/tabs';
import { PerfectScrollbarConfigInterface, PerfectScrollbarModule } from 'ngx-perfect-scrollbar';
import { GrowlModule } from 'primeng/growl';
import { AppComponent } from './app.component';
// Import routing module
import { AppRoutingModule } from './app.routing';
// Import containers
import { FullLayoutComponent} from './containers';
import { TreeModule } from 'angular-tree-component';
import { LoginComponent } from './views/login';
import { MateriaComponent } from './views/materia/materia.component';
import { HeaderComponent } from './containers/header/header.component';
import { FooterComponent } from './containers/footer/footer.component';
import { MenuComponent } from './containers/menu/menu.component';
import { NotaComponent } from './views/nota/nota.component';

const DEFAULT_PERFECT_SCROLLBAR_CONFIG: PerfectScrollbarConfigInterface = {
  suppressScrollX: true
};
const APP_CONTAINERS = [
  FullLayoutComponent
]
@NgModule({
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    HttpModule,
    ReactiveFormsModule,
    FormsModule,
    ReactiveFormsModule,
    CommonModule,
    CalendarModule,
    FullCalendarModule,
    AppAsideModule,
    AppBreadcrumbModule.forRoot(),
    AppSidebarModule,

    PerfectScrollbarModule,
    BsDropdownModule.forRoot(),
    TabsModule.forRoot(),
    AvatarModule.forRoot(),
    GrowlModule,
    TreeModule
  ],

  declarations: [
    AppComponent,
    ...APP_CONTAINERS,
    LoginComponent,
    MateriaComponent,
    HeaderComponent,
    FooterComponent,
    MenuComponent,
    NotaComponent
  ],
  entryComponents: [ ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
