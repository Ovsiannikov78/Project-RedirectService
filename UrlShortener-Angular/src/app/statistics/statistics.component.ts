import { Component, OnInit } from '@angular/core';
import {StatisticService} from '../services/statistic.service';
import {Statistic} from '../model/statistic';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-statistics',
  templateUrl: './statistics.component.html',
  styleUrls: ['./statistics.component.css']
})
export class StatisticsComponent implements OnInit {

  statistics: Observable<Statistic[]>;

  constructor(private statisticService: StatisticService) { }

  ngOnInit(): void {
    this.top5StatisticList();
  }


  private top5StatisticList(): void {
     this.statistics = this.statisticService.getStatistic();
  }
}
