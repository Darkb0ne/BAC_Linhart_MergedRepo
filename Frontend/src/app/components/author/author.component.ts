import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MatTableDataSource } from '@angular/material/table';
import { IServerAuthor } from 'src/app/models/IServerAuthor.model';
import { ApiService } from 'src/app/services/api.service';
import { Observable, of } from 'rxjs';
import { map } from 'rxjs/operators';
import { MatSort, Sort } from '@angular/material/sort';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { sortRows, fromMatSort, fromMatPaginator, paginateRows } from 'src/app/helpers/datautils.helper';


@Component({
  selector: 'app-author',
  templateUrl: './author.component.html',
  styleUrls: ['./author.component.scss']
})
export class AuthorComponent implements OnInit {

  @ViewChild(MatSort)
  sort: MatSort = new MatSort;
  @ViewChild(MatPaginator, { static: true }) paginator!: MatPaginator;

  author!: IServerAuthor[];
  dataSource?: MatTableDataSource<IServerAuthor>;

  totalRows!: Observable<number>;
  displayedRows!: Observable<IServerAuthor[]>;

  constructor(private _apiService: ApiService, private _route: ActivatedRoute) { }

  
  ngOnInit(): void {

    const sortEvents: Observable<Sort> = fromMatSort(this.sort);
    const pageEvents: Observable<PageEvent> = fromMatPaginator(this.paginator);
    const numberid = this._route.snapshot.paramMap.get('id');


    this._apiService.getAllAuthor$().subscribe(author => {
      this.author = author;
      
    })

    const rows$ = of(this.author);

    this.totalRows = rows$.pipe(map(rows => rows?.length));
    //this.displayedRows = rows$.pipe(sortRows(sortEvents), paginateRows(pageEvents));
    ///paginateRows(pageEvents);

    //this.callLog();
    
  }

  ngAfterViewInit() {

  }

  callLog(): void {
    console.log(this.author);
  }

}
