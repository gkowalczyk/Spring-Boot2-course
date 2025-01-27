import { Component } from '@angular/core';
import { GameComponent } from './components/game/game.component';
import {HttpClientModule} from '@angular/common/http';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [GameComponent, HttpClientModule], // Importuj GameComponent

  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'my-angular-project';
}
