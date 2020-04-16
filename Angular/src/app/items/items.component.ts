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
  totals: Observable<Item[]>;

  ngOnInit() {
    this.itemService.getItems().subscribe(data => {
      this.items = data;
    })
    this.itemService.getTotals().subscribe(data => {
      this.totals = data;
    })

  }

  deleteItem(id: number) {
    this.itemService.deleteItem(id)
      .subscribe(
        data => {
          console.log(data + "aaa");
          this.itemService.getItems().subscribe(data => {
            this.items = data
          })
        },
        error => console.log(error));
        
    this.itemService.getTotals().subscribe(data => {
      this.totals = data;
    })
  }
}