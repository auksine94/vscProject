import { Component, OnInit } from '@angular/core';
import { Observable } from "rxjs";

import { ItemService } from '../item.service';
import { Item } from '../item';

@Component({
  selector: 'app-items',
  templateUrl: './items.component.html'
})
export class ItemsComponent implements OnInit {

  constructor(private itemService: ItemService) { }

  items: Observable<Item[]>;

  ngOnInit() {
    this.itemService.getItems().subscribe(data => {
      this.items = data;
    })
  }
}