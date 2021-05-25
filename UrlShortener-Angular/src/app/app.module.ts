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
import { RedirectComponent } from './redirect/redirect.component';

@NgModule({
  declarations: [
    AppComponent,
    StatisticsComponent,
    InputFormComponent,
    ShortUrlComponent,
    RedirectComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [UrlService, StatisticService],
  bootstrap: [AppComponent]
})
export class AppModule { }
