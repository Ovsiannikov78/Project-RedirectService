import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import {AppRoutingModule} from './app-routing.module';
import {StatisticsComponent} from './statistics/statistics.component';
import {InputFormComponent} from './input-form/input-form.component';
import {ShortUrlComponent} from './short-url/short-url.component';
import {HttpClientModule} from '@angular/common/http';
import {UrlService} from './services/url.service';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {StatisticService} from './services/statistic.service';
import { SafePipe } from './short-url/safe.pipe';
import {ChartsModule} from 'ng2-charts';
import { StatisticsBarChartComponent } from './statistics-bar-chart/statistics-bar-chart.component';

@NgModule({
  declarations: [
    AppComponent,
    StatisticsComponent,
    InputFormComponent,
    ShortUrlComponent,
    SafePipe,
    StatisticsBarChartComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    ChartsModule
  ],
  providers: [UrlService, StatisticService],
  bootstrap: [AppComponent]
})
export class AppModule { }
