import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppAsideModule, AppBreadcrumbModule, AppFooterModule, AppHeaderModule, AppSidebarModule } from '@coreui/angular';
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
import { LoginComponent } from './containers';


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
    ReactiveFormsModule,
    FormsModule,
    ReactiveFormsModule,
    CommonModule,
    CalendarModule,
    FullCalendarModule,
    AppAsideModule,
    AppBreadcrumbModule.forRoot(),
    AppFooterModule,
    AppHeaderModule,
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
    LoginComponent
  ],
  entryComponents: [ ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
