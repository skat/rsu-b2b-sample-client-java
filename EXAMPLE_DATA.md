## Simulation af VAT reporting

| No. | Line                                                      | Submitted in Request | Reconcile     |
|-----|-----------------------------------------------------------|----------------------|---------------|
| 1   | Salgsmoms (udgående moms)                                 | 1.000                | 1.000         |
| 2   | Købsmoms (indgående moms)                                 | 500                  | -375 (*)      |
|     | **Handel med udlandet**                                   |                      |               |
| 3   | Moms af varekøb i udlandet                                | 50                   |               |
| 4   | Moms af ydelseskøb i udlandet med omvendt betalingspligt  | 75                   |               |
| 5   | Rubrik A - varer                                          |                      |               |
| 6   | Rubrik A - ydelser                                        |                      |               |
| 7   | Rubrik B - varer (EU-salg uden moms)                      |                      |               |
| 8   | Rubrik B - varer                                          |                      |               |
| 9   | Rubrik B - ydelser                                        |                      |               |
| 10  | Rubrik C                                                  |                      |               |
|     | **Energiafgifter**                                        |                      |               |
| 11  | Olie- og flaskeafgift                                     | 10                   | -10           |
| 12  | El-afgift                                                 | 20                   | -20           |
| 13  | Naturgas- og bygasafgift                                  | 30                   | -30           |
| 14  | Kulafgift                                                 | 40                   | -40           |
| 15  | CO2-afgift                                                | 50                   | -50           |
| 16  | Vandafgift                                                | 60                   | -60           |
| 17  | **Tilsvar (positiv: betaling, negativ: tilbagebetaling)** | **415**              | SUM = **415** |


(*) Calculation (**Købsmoms (indgående moms)** x -1) + **Moms af varekøb i udlandet** + **Moms af ydelseskøb i udlandet med omvendt betalingspligt**



