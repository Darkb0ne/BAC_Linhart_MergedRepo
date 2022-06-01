import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { IServerAttraction } from 'src/app/models/IServerAttraction.model';
import { IServerNews, IDictionary } from 'src/app/models/IServerNews.model';
import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-statistics-attraction-lastmonth',
  templateUrl: './statistics-attraction-lastmonth.component.html',
  styleUrls: ['./statistics-attraction-lastmonth.component.scss']
})
export class StatisticsAttractionLastmonthComponent implements OnInit {
  
  response!: IDictionary;
  result?: MatTableDataSource<IServerAttraction>; 
  columnNames = [ 'attraction', 'viewCount'];

  constructor(private _apiService: ApiService) { }

  ngOnInit(): void {
    this._apiService.getAttractionStatisticsMonthly$().subscribe(res => {

      const attractions = [];

      for (let locationName in res) {
        const viewC = res[locationName];
        const attraction: IServerAttraction = {name: locationName, viewCount: viewC};
        attractions.push(attraction);
      }

      this.result = new MatTableDataSource<IServerAttraction>(attractions);

      //console.log(this.statsAttractionAlltime);
      console.log(this.result);
    });
  }

}
