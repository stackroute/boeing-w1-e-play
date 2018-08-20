import { Component, OnInit } from '@angular/core';
import { SearchDataService } from "../search-data.service";

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {
  omdbSearchTitle: string;

  constructor(
    private data: SearchDataService
  ) { }

  ngOnInit() {
  }
  onSearch(){
    console.log(this.omdbSearchTitle);
    this.data.changeMessage(this.omdbSearchTitle);

  }
}
