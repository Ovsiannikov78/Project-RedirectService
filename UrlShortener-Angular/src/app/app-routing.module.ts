import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {InputFormComponent} from './input-form/input-form.component';
import {StatisticsComponent} from './statistics/statistics.component';
import {ShortUrlComponent} from './short-url/short-url.component';

const routes: Routes = [
  {path: '', redirectTo: '/urls', pathMatch: 'full'},
  {path: 'urls', component: InputFormComponent},
  {path: 'urls/:shortUrlId', component: ShortUrlComponent},
  {path: 'statistics', component: StatisticsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}

