import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent  {
  title = 'Academic Planner';

  static API_URL='http://localhost:8080';

  constructor() { }

  @Input() login: boolean = true;

}
