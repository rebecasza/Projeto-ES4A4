import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
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
import { AppRoutingModule } from './app-routing.module';
// Import containers
import { FullLayoutComponent} from './containers';
import { TreeModule } from 'angular-tree-component';
import { LoginComponent } from './views/login';
import { MateriaComponent } from './views/materia/materia.component';
import { HeaderComponent } from './containers/header/header.component';
import { FooterComponent } from './containers/footer/footer.component';
import { MenuComponent } from './containers/menu/menu.component';
import { NotaComponent } from './views/nota/nota.component';
import { RegistroComponent } from './views/registro/registro.component';
import { CalendarioComponent} from './views/calendario';
import { PlanejamentoComponent } from './views/planejamento/planejamento.component';
import { TopicoComponent } from './views/topico/topico.component';
// Angular materials
import {  MatExpansionModule,
          MatButtonModule,
          MatCardModule } from '@angular/material';
// Import services
import { UsuarioService } from './services/usuario.service';
import { MateriaService } from './services/materia.service';
import { NotaService } from './services/nota.service';
import { EstudoService } from './services/estudo.service';
import { TopicoService } from './services/topico.service';

const DEFAULT_PERFECT_SCROLLBAR_CONFIG: PerfectScrollbarConfigInterface = {
  suppressScrollX: true
};
const APP_CONTAINERS = [
  FullLayoutComponent
];

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
    AppSidebarModule,
    MatCardModule,
    MatButtonModule,
    MatExpansionModule,

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
    NotaComponent,
    RegistroComponent,
    CalendarioComponent,
    PlanejamentoComponent,
    TopicoComponent
  ],
  providers: [
    UsuarioService,
    MateriaService,
    NotaService,
    EstudoService,
    TopicoService
  ],
  entryComponents: [],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
