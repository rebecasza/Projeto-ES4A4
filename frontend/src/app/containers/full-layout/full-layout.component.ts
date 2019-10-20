import { Component } from '@angular/core';
import dayGridPlugin from '@fullcalendar/daygrid';

@Component({
  selector: 'app-dashboard',
  templateUrl: './full-layout.component.html'
})

export class FullLayoutComponent {
  calendarPlugins = [dayGridPlugin];
}

