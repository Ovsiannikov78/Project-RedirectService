import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {InputFormComponent} from './input-form/input-form.component';
import {StatisticsComponent} from './statistics/statistics.component';
import {ShortUrlComponent} from './short-url/short-url.component';
import {RedirectComponent} from './redirect/redirect.component';

const routes: Routes = [
  {path: '', redirectTo: '/urls', pathMatch: 'full'},
  {path: 'urls', component: InputFormComponent},
  {path: 'urls/shorturl/{shortUrl}', component: RedirectComponent},
  {path: 'urls/shorturl', component: ShortUrlComponent},
  {path: 'statistics', component: StatisticsComponent}
  /*{path: 'urls/statistics', redirectTo: '/statistics', component: StatisticsComponent},*/

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}

