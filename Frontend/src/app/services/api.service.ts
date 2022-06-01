import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IServerAuthor } from '../models/IServerAuthor.model';
import { IServerNews } from '../models/IServerNews.model';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

    readonly APIUrl = "http://localhost:9292/api/v1";
    readonly StatAPIUrl = "http://localhost:9292/api/v1";

    constructor(private _http: HttpClient) { }

    getNews$(index: string): Observable<IServerNews> {
      return this._http.get<IServerNews>(this.APIUrl + '/news/' + index);
    }

    getAuthorOfNews$(index: string): Observable<IServerAuthor[]> {
      return this._http.get<IServerAuthor[]>(this.APIUrl + '/authors/news/' + index);
    }

    getAllAuthor$(): Observable<IServerAuthor[]> {
      return this._http.get<IServerAuthor[]>(this.APIUrl + '/authors');
    }

    getAllNews$(): Observable<any> {
      return this._http.get<any>(this.APIUrl + '/news');
    }

    setNews$(instance: any): Observable<any> {
      console.log(instance);
      return this._http.post(this.APIUrl + '/news', instance);
    }

    getNewsStatisticsMonthly$(): Observable<any> {
      return this._http.get<any>(this.StatAPIUrl + '/statistics/news/last-month');
    }

    getNewsStatisticsAlltime$(): Observable<any> {
      return this._http.get<any>(this.StatAPIUrl + '/statistics/news/all-time');
    }

    getAttractionStatisticsMonthly$(): Observable<any> {
      return this._http.get<any>(this.StatAPIUrl + '/statistics/attraction/last-month');
    }

    getAttractionStatisticsAlltime$(): Observable<any> {
      return this._http.get<any>(this.StatAPIUrl + '/statistics/attraction/all-time');
    }
}
