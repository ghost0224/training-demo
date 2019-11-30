import { BrowserModule } from '@angular/platform-browser';
import {ElementRef, NgModule, ViewChild} from '@angular/core';

import { AppComponent } from './app.component';
import {LocalStorage} from './common/local.storage';
import {HttpModule, JsonpModule} from '@angular/http';
import {RouterModule, Routes} from '@angular/router';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { TrainingComponent } from './training/training.component';
import { SearchComponent } from './search/search.component';
import { PayComponent } from './pay/pay.component';
import { HistoryComponent } from './history/history.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'search', component: SearchComponent},
  {path: 'pay', component: PayComponent},
  {path: 'history', component: HistoryComponent},
  {path: 'current', component: TrainingComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    TrainingComponent,
    SearchComponent,
    PayComponent,
    HistoryComponent
  ],
  imports: [
    BrowserModule, HttpModule, JsonpModule, RouterModule.forRoot(routes), ReactiveFormsModule, FormsModule
  ],
  exports: [RouterModule],
  providers: [LocalStorage],
  bootstrap: [AppComponent]
})
export class AppModule {
}
