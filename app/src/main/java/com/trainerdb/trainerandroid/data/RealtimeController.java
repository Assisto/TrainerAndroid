package com.trainerdb.trainerandroid.data;

import com.trainerdb.trainerandroid.TrainApplication;
import com.trainerdb.trainerandroid.train.DeviceConfiguration;
import com.trainerdb.trainerandroid.train.RealtimeData;

/**
 * Created by dcotrim on 22/06/2016.
 */
public abstract class RealtimeController {
    DeviceConfiguration device;
    final double  MILES_PER_KM = 0.621371;

    public RealtimeController(DeviceConfiguration device) {
        this.device = device;
    }

    public void processRealTimeData(RealtimeData rtData) {

        switch (TrainApplication.getVirtualPowerId()) {
            case 5 : // Lemond Revolution
            {
                double V = rtData.getSpeed() * 0.277777778;
                // Tom Anhalt spent a lot of time working this all out
                // for the data / analysis see: http://wattagetraining.com/forum/viewtopic.php?f=2&t=335
                rtData.setWatts((0.21* Math.pow(V,3))+(4.25*V));
            }
            break;

            case 6 : // 1UP USA
            {
                double V = rtData.getSpeed() * MILES_PER_KM;
                // Power curve provided by extraction from SportsTracks plugin
                rtData.setWatts(25.00 + (2.65f*V) - (0.42f*Math.pow(V,2)) + (0.058f*Math.pow(V,3)));
            }
            break;

            // MINOURA - Has many gears
            case 7 : //MINOURA V100 on H
            {
                double V = rtData.getSpeed();
                // 7 = V100 on H: y = -0.0036x^3 + 0.2815x^2 + 3.4978x - 9.7857
                rtData.setWatts(-0.0036*Math.pow(V, 3) + 0.2815*Math.pow(V,2) + (3.4978*V) - 9.7857);
            }
            break;

            case 8 : //MINOURA V100 on 5
            {
                double V = rtData.getSpeed();
                // 8 = V100 on 5: y = -0.0023x^3 + 0.2067x^2 + 3.8906x - 11.214
                rtData.setWatts(-0.0023*Math.pow(V, 3) + 0.2067*Math.pow(V,2) + (3.8906*V) - 11.214);
            }
            break;

            case 9 : //MINOURA V100 on 4
            {
                double V = rtData.getSpeed();
                // 9 = V100 on 4: y = -0.00173x^3 + 0.1825x^2 + 3.4036x - 10
                rtData.setWatts(-0.00173*Math.pow(V, 3) + 0.1825*Math.pow(V,2) + (3.4036*V) - 10.00);
            }
            break;

            case 10 : //MINOURA V100 on 3
            {
                double V = rtData.getSpeed();
                // 10 = V100 on 3: y = -0.0011x^3 + 0.1433x^2 + 2.8808x - 8.1429
                rtData.setWatts(-0.0011*Math.pow(V, 3) + 0.1433*Math.pow(V,2) + (2.8808*V) - 8.1429);
            }
            break;

            case 11 : //MINOURA V100 on 2
            {
                double V = rtData.getSpeed();
                // 11 = V100 on 2: y = -0.0007x^3 + 0.1348x^2 + 1.581x - 3.3571
                rtData.setWatts(-0.0007*Math.pow(V, 3) + 0.1348*Math.pow(V,2) + (1.581*V) - 3.3571);
            }
            break;

            case 12 : //MINOURA V100 on 1
            {
                double V = rtData.getSpeed();
                // 12 = V100 on 1: y = 0.0004x^3 + 0.057x^2 + 1.7797x - 5.0714
                rtData.setWatts(0.0004*Math.pow(V, 3) + 0.057*Math.pow(V,2) + (1.7797*V) - 5.0714);
            }
            break;

            case 13 : //MINOURA V100 on L
            {
                double V = rtData.getSpeed();
                // 13 = V100 on L: y = 0.0557x^2 + 1.231x - 3.7143
                rtData.setWatts(0.0557*Math.pow(V, 2) + (1.231*V) - 3.7143);
            }
            break;

            case 14 : //MINOURA V270/v130 on H
            {
                double V = rtData.getSpeed();
                rtData.setWatts(-1.84615384615e-06*Math.pow(V, 5) + 0.000338955162485*Math.pow(V, 4) + -0.0237725215961*Math.pow(V, 3) + 0.782320032908*Math.pow(V, 2) + 0.538329905388*V + -0.628959276017);
            }
            break;

            case 15 : //MINOURA V270/v130 on 5
            {
                double V = rtData.getSpeed();
                rtData.setWatts(-9.35143288085e-07*Math.pow(V, 5) + 0.000193281228575*Math.pow(V, 4) + -0.0153105032223*Math.pow(V, 3) + 0.587825311943*Math.pow(V, 2) + 1.16395173454*V + -0.472850678733);
            }
            break;

            case 16 : //MINOURA V270/v130 on 4
            {
                double V = rtData.getSpeed();
                rtData.setWatts(-3.34841628959e-07*Math.pow(V, 5) + 0.000114219114219*Math.pow(V, 4) + -0.0117029686*Math.pow(V, 3) + 0.52033045386*Math.pow(V, 2) + 1.10649184149*V + -0.364253393665);
            }
            break;

            case 17 : //MINOURA V270/v130 on 3
            {
                double V = rtData.getSpeed();
                rtData.setWatts(2.32277526395e-07*Math.pow(V, 5) + 3.96681749623e-05*Math.pow(V, 4) + -0.00805837789661*Math.pow(V, 3) + 0.439146098999*Math.pow(V, 2) + 1.00085150144*V + -0.386877828054);
            }
            break;

            case 18 : //MINOURA V270/v130 on 2
            {
                double V = rtData.getSpeed();
                rtData.setWatts(-5.58069381599e-07*Math.pow(V, 5) + 0.000123625394214*Math.pow(V, 4) + -0.0103757370081*Math.pow(V, 3) + 0.434414507062*Math.pow(V, 2) + 0.278777594954*V + -0.00678733031682);
            }
            break;

            case 19 : //MINOURA V270/v130 on 1
            {
                double V = rtData.getSpeed();
                rtData.setWatts(3.74057315234e-07*Math.pow(V, 5) + -1.7235705471e-05*Math.pow(V, 4) + -0.00251391745509*Math.pow(V, 3) + 0.237884615385*Math.pow(V, 2) + 0.704304812834*V + -0.056561085973);
            }
            break;

            case 20 : //MINOURA V270/v130 on L
            {
                double V = rtData.getSpeed();
                rtData.setWatts(3.46907993967e-07*Math.pow(V, 5) + -3.38406691348e-05*Math.pow(V, 4) + -6.92787604552e-05*Math.pow(V, 3) + 0.122555189908*Math.pow(V, 2) + 0.642516796929*V + -0.0859728506788);
            }
            break;

            case 21 : //SARIS POWERBEAM PRO
            {
                double V = rtData.getSpeed();
                // 21 = 0.0008x^3 + 0.145x^2 + 2.5299x + 14.641 where x = speed in kph
                rtData.setWatts(0.0008*Math.pow(V, 3) + 0.145*Math.pow(V, 2) + (2.5299*V) + 14.641);
            }
            break;

            case 22 : //  TACX SATORI SETTING 2
            {
                double V = rtData.getSpeed();
                double slope = 3.9;
                double intercept = -19.5;
                rtData.setWatts((slope * V) + intercept);
            }
            break;

            case 23 : //  TACX SATORI SETTING 4
            {
                double V = rtData.getSpeed();
                double slope = 6.66;
                double intercept = -52.3;
                rtData.setWatts((slope * V) + intercept);
            }
            break;

            case 24 : //  TACX SATORI SETTING 6
            {
                double V = rtData.getSpeed();
                double slope = 9.43;
                double intercept = -43.65;
                rtData.setWatts((slope * V) + intercept);
            }
            break;

            case 25 : //  TACX SATORI SETTING 8
            {
                double V = rtData.getSpeed();
                double slope = 13.73;
                double intercept = -51.15;
                rtData.setWatts((slope * V) + intercept);
            }
            break;

            case 26 : //  TACX SATORI SETTING 10
            {
                double V = rtData.getSpeed();
                double slope = 17.7;
                double intercept = -76.0;
                rtData.setWatts((slope * V) + intercept);
            }
            break;

            case 27 : //  TACX FLOW SETTING 0
            {
                double V = rtData.getSpeed();
                double slope = 7.75;
                double intercept = -47.27;
                rtData.setWatts((slope * V) + intercept);
            }
            break;

            case 28 : //  TACX FLOW SETTING 2
            {
                double V = rtData.getSpeed();
                double slope = 9.51;
                double intercept = -66.69;
                rtData.setWatts((slope * V) + intercept);
            }
            break;

            case 29 : //  TACX FLOW SETTING 4
            {
                double V = rtData.getSpeed();
                double slope = 11.03;
                double intercept = -71.59;
                rtData.setWatts((slope * V) + intercept);
            }
            break;

            case 30 : //  TACX FLOW SETTING 6
            {
                double V = rtData.getSpeed();
                double slope = 12.81;
                double intercept = -95.05;
                rtData.setWatts((slope * V) + intercept);
            }
            break;

            case 31 : //  TACX FLOW SETTING 8
            {
                double V = rtData.getSpeed();
                double slope = 14.37;
                double intercept = -102.43;
                rtData.setWatts((slope * V) + intercept);
            }
            break;

            case 32 : //  TACX BLUE TWIST SETTING 1
            {
                double V = rtData.getSpeed();
                double slope = 3.2;
                double intercept = -24.0;
                rtData.setWatts((slope * V) + intercept);
            }
            break;

            case 33 : //  TACX BLUE TWIST SETTING 3
            {
                double V = rtData.getSpeed();
                double slope = 6.525;
                double intercept = -46.5;
                rtData.setWatts((slope * V) + intercept);
            }
            break;

            case 34 : //  TACX BLUE TWIST SETTING 5
            {
                double V = rtData.getSpeed();
                double slope = 9.775;
                double intercept = -66.5;
                rtData.setWatts((slope * V) + intercept);
            }
            break;

            case 35 : //  TACX BLUE TWIST SETTING 7
            {
                double V = rtData.getSpeed();
                double slope = 13.075;
                double intercept = -89.5;
                rtData.setWatts((slope * V) + intercept);
            }
            break;

            case 36 : //  TACX BLUE MOTION SETTING 2
            {
                double V = rtData.getSpeed();
                double slope = 5.225;
                double intercept = -36.5;
                rtData.setWatts((slope * V) + intercept);
            }
            break;

            case 37 : //  TACX BLUE MOTION SETTING 4
            {
                double V = rtData.getSpeed();
                double slope = 8.25;
                double intercept = -53.0;
                rtData.setWatts((slope * V) + intercept);
            }
            break;

            case 38 : //  TACX BLUE MOTION SETTING 6
            {
                double V = rtData.getSpeed();
                double slope = 11.45;
                double intercept = -74.0;
                rtData.setWatts((slope * V) + intercept);
            }
            break;

            case 39 : //  TACX BLUE MOTION SETTING 8
            {
                double V = rtData.getSpeed();
                double slope = 14.45;
                double intercept = -89.0;
                rtData.setWatts((slope * V) + intercept);
            }
            break;

            case 40 : //  TACX BLUE MOTION SETTING 10
            {
                double V = rtData.getSpeed();
                double slope = 17.575;
                double intercept = -110.5;
                rtData.setWatts((slope * V) + intercept);
            }
            break;

            case 41 : // ELITE SUPERCRONO POWER MAG LEVEL 1
            {
                double V = rtData.getSpeed() * MILES_PER_KM;
                // Power curve provided by extraction from SportsTracks plugin
                rtData.setWatts(-0.000803192769148186*Math.pow(V, 3) + 0.17689196198325*Math.pow(V,2) + (3.62446277061515*V) - 1.16783216783223);
            }
            break;

            case 42 : // ELITE SUPERCRONO POWER MAG LEVEL 2
            {
                double V = rtData.getSpeed() * MILES_PER_KM;
                // Power curve provided by extraction from SportsTracks plugin
                rtData.setWatts(-0.00590735326986424*Math.pow(V, 3) + 0.442531768374482*Math.pow(V,2) + (3.54843470904764*V) - 0.363636363636395);
            }
            break;

            case 43 : // ELITE SUPERCRONO POWER MAG LEVEL 3
            {
                double V = rtData.getSpeed() * MILES_PER_KM;
                // Power curve provided by extraction from SportsTracks plugin
                rtData.setWatts(-0.00917194323478923*Math.pow(V, 3) + 0.614352424962992*Math.pow(V,2) + (5.08762781732785*V) - 1.48951048951047);
            }
            break;

            case 44 : // ELITE SUPERCRONO POWER MAG LEVEL 4
            {
                double V = rtData.getSpeed() * MILES_PER_KM;
                // Power curve provided by extraction from SportsTracks plugin
                rtData.setWatts(-0.0150015681721553*Math.pow(V, 3) + 0.880112976720764*Math.pow(V,2) + (5.16903286351279*V) - 1.7342657342657);
            }
            break;

            case 45 : // ELITE SUPERCRONO POWER MAG LEVEL 5
            {
                double V = rtData.getSpeed() * MILES_PER_KM;
                // Power curve provided by extraction from SportsTracks plugin
                rtData.setWatts(-0.0172621671756449*Math.pow(V, 3) + 1.0207209560583*Math.pow(V,2) + (6.23730215622854*V) - 3.18881118881126);
            }
            break;

            case 46 : // ELITE SUPERCRONO POWER MAG LEVEL 6
            {
                double V = rtData.getSpeed() * MILES_PER_KM;
                // Power curve provided by extraction from SportsTracks plugin
                rtData.setWatts(-0.0195227661791347*Math.pow(V, 3) + 1.15505017633569*Math.pow(V,2) + (7.47138264900755*V) - 4.18881118881114);
            }
            break;

            case 47 : // ELITE SUPERCRONO POWER MAG LEVEL 7
            {
                double V = rtData.getSpeed() * MILES_PER_KM;
                // Power curve provided by extraction from SportsTracks plugin
                rtData.setWatts(-0.0222497351776137*Math.pow(V, 3) + 1.2917943039439*Math.pow(V,2) + (8.74972948026508*V) - 5.11888111888112);
            }
            break;

            case 48 : // ELITE SUPERCRONO POWER MAG LEVEL 8
            {
                double V = rtData.getSpeed() * MILES_PER_KM;
                // Power curve provided by extraction from SportsTracks plugin
                rtData.setWatts(-0.0255078477814972*Math.pow(V, 3) + 1.42902141301828*Math.pow(V,2) + (10.2050166192824*V) - 6.48951048951042);
            }
            break;

            case 49: //ELITE TURBO MUIN 2013
            {
                double V = rtData.getSpeed();
                // Power curve fit from data collected by Ray Maker at dcrainmaker.com
                rtData.setWatts(2.30615942 * V -0.28395558 * Math.pow(V,2) + 0.02099661 * Math.pow(V,3));
            }
            break;
            case 50: // ELITE QUBO POWER FLUID
            {
                double V = rtData.getSpeed();
                // Power curve fit from powercurvesensor
                //     f(x) = 4.31746 * x -2.59259e-002 * x^2 +  9.41799e-003 * x^3
                rtData.setWatts(4.31746 * V - 2.59259e-002 * Math.pow(V, 2) + 9.41799e-003 * Math.pow(V, 3));
            }
            break;
            case 51: // CYCLOPS MAGNETO PRO (ROAD)
            {
                double V = rtData.getSpeed();
                //     Watts = 6.0f + (-0.93 * speed) + (0.275 * speed^2) + (-0.00175 * speed^3)
                rtData.setWatts(6.0f + (-0.93f * V) + (0.275f * Math.pow(V, 2)) + (-0.00175f * Math.pow(V, 3)));
            }
            break;

            case 52: // ELITE ARION MAG LEVEL 0
            {
                double v = rtData.getSpeed();
                rtData.setWatts(Math.pow(v, 1.217110021) * 3.335794377);
            }
            break;

            case 53: // ELITE ARION MAG LEVEL 1
            {
                double v = rtData.getSpeed();
                rtData.setWatts(Math.pow(v, 1.206592577) * 4.362485081);
            }
            break;

            case 54: // ELITE ARION MAG LEVEL 2
            {
                double v = rtData.getSpeed();
                rtData.setWatts(Math.pow(v, 1.206984321) * 6.374459698);
            }
            break;

            case 55: // Blackburn Tech Fluid
            {
                double v = rtData.getSpeed();
                rtData.setWatts(6.758241758241894 - 1.9995004995004955 * v + 0.24165834165834146 * Math.pow(v, 2));
            }
            break;

            case 56: // TACX SIRIUS LEVEL 1
            {
                double v = rtData.getSpeed();
                rtData.setWatts(3.23874687 * v - 20.64808196);
            }
            break;

            case 57: // TACX SIRIUS LEVEL 2
            {
                double v = rtData.getSpeed();
                rtData.setWatts(4.30606133 * v - 27.25589246);
            }
            break;

            case 58: // TACX SIRIUS LEVEL 3
            {
                double v = rtData.getSpeed();
                rtData.setWatts(5.44879778 * v - 36.57159131);
            }
            break;

            case 59: // TACX SIRIUS LEVEL 4
            {
                double v = rtData.getSpeed();
                rtData.setWatts(6.48525956 * v - 40.48616615);
            }
            break;

            case 60: // TACX SIRIUS LEVEL 5
            {
                double v = rtData.getSpeed();
                rtData.setWatts(7.60643338 * v - 48.35481582);
            }
            break;

            case 61: // TACX SIRIUS LEVEL 6
            {
                double v = rtData.getSpeed();
                rtData.setWatts(8.73140257 * v - 58.57819586);
            }
            break;

            case 62: // TACX SIRIUS LEVEL 7
            {
                double v = rtData.getSpeed();
                rtData.setWatts(9.73079724 * v - 59.61416463);
            }
            break;

            case 63: // TACX SIRIUS LEVEL 8
            {
                double v = rtData.getSpeed();
                rtData.setWatts(10.94228338 * v - 73.08258491);
            }
            break;

            case 64: // TACX SIRIUS LEVEL 9
            {
                double v = rtData.getSpeed();
                rtData.setWatts(11.99373782 * v - 77.88781457);
            }
            break;

            case 65: // TACX SIRIUS LEVEL 10
            {
                double v = rtData.getSpeed();
                rtData.setWatts(13.09580164 * v - 85.38477516);
            }
            break;

            case 101: // TACX SIRIUS LEVEL 10
            {
                double v = rtData.getSpeed();
                rtData.setWatts(13.09580164 * v - 85.38477516);
            }
            break;

            default : // unknown - do nothing
                break;
        }
    }

    public abstract void getRealtimeData(RealtimeData rtData);

    public abstract void start();

    public abstract void stop();

    public abstract void setLoad(double load);
}
