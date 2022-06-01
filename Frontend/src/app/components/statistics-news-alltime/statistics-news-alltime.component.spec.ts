import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StatisticsNewsAlltimeComponent } from './statistics-news-alltime.component';

describe('StatisticsNewsAlltimeComponent', () => {
  let component: StatisticsNewsAlltimeComponent;
  let fixture: ComponentFixture<StatisticsNewsAlltimeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StatisticsNewsAlltimeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StatisticsNewsAlltimeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
