import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StatisticsNewsLastmonthComponent } from './statistics-news-lastmonth.component';

describe('StatisticsNewsLastmonthComponent', () => {
  let component: StatisticsNewsLastmonthComponent;
  let fixture: ComponentFixture<StatisticsNewsLastmonthComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StatisticsNewsLastmonthComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StatisticsNewsLastmonthComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
