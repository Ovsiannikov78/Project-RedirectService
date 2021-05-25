import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Statistic} from '../model/statistic';


@Injectable({
  providedIn: 'root'
})
export class StatisticService {

  private statisticUrl = 'http://localhost:8090/statistics';

  constructor(private http: HttpClient) { }

  getStatistic(): Observable<Statistic[]> {
    return this.http.get<Statistic[]>(this.statisticUrl);
  }
}

