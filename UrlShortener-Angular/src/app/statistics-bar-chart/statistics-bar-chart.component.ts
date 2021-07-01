import { Component, OnInit } from '@angular/core';
import {ChartOptions, ChartType} from 'chart.js';
import {StatisticService} from '../services/statistic.service';
import {Subscription} from 'rxjs';


@Component({
  selector: 'app-statistics-bar-chart',
  templateUrl: './statistics-bar-chart.component.html',
  styleUrls: ['./statistics-bar-chart.component.css']
})
export class StatisticsBarChartComponent implements OnInit {

  shortLinks: string[];
  numberOfUses: number[];
  loading = false;


  barChartOptions: ChartOptions = {
    responsive: true,
    scales: {
      xAxes: [
        {
          ticks: {
            beginAtZero: true
          }
        }
      ]
    }
  };

  barChartLabels: Array<any> = [];

  barChartData: Array<{ data: number[], label: string }> = [];

  barChartType: ChartType = 'horizontalBar';

  public barChartColors: Array<any> = [
    {
      backgroundColor: [
        'rgba(255, 99, 132, 0.2)',
        'rgba(54, 162, 235, 0.2)',
        'rgba(255, 206, 86, 0.2)',
        'rgba(75, 192, 192, 0.2)',
        'rgba(153, 102, 255, 0.2)',
        'rgba(255, 159, 64, 0.2)'
      ],
      borderColor: [
        'rgba(255,99,132,1)',
        'rgba(54, 162, 235, 1)',
        'rgba(255, 206, 86, 1)',
        'rgba(75, 192, 192, 1)',
        'rgba(153, 102, 255, 1)',
        'rgba(255, 159, 64, 1)'
      ],
      borderWidth: 2,
    }
  ];


  constructor(private statisticService: StatisticService) { }

  ngOnInit(): void {
   const barChartLabels: Subscription = this.statisticService.getStatistic().subscribe(
        data => {
          this.barChartLabels = data.map(value => value.shortUrl) ;
          this.numberOfUses = data.map(value => value.counter);
          this.barChartData.push({data: this.numberOfUses, label: 'Top 5 Most Used Short Links'});
          this.loading = true;
        }
    );
   console.log('barChartLabels ', barChartLabels);
  }

  public chartClicked(e: any): void { }
  public chartHovered(e: any): void { }
}
