# Camel Case Writer

## Introduction

Fra VOP F11 Eksamen

Hovedemner:

  - File I/O
  - Operationer på tekst-strenge og karakterer
  - Exception Handling

## Task

I denne opgave skal der udvikles et java program, som tager en tekst fil som input og konverterer hver linje
til ét ord, skrevet i kamel skrift efter konventionen for java-metoder og -variable:

  - Det første ord i linjen skrives med småbogstaver
  - Efterfølgende ord skrives med stort begyndelsesbogstav
  - Ordene sættes sammen uden mellemrum
  
Når en linje er konverteret til et ord i kamel skrift, udskrives den med `System.out.println()`.

Eksempel: Første vers af __Dúnés Dry Lips__ før og efter konvertering:

```
I'm walking down my neighbourhood
Where every child is crying
You're the only one who sees me
You're the only one who'll kiss me
On my dry lips
```
```
i'mWalkingDownMyNeighbourhood
whereEveryChildIsCrying
you'reTheOnlyOneWhoSeesMe
you'reTheOnlyOneWho'llKissMe
onMyDryLips
```

__Hint__:
  - For at tilgå filer i `resources` directory'et kan flg. benyttes:
    - Fra en statisk kontekst: `CamelWriter.class.getClassLoader().getResource("filename").getFile()`
    - Fra en instans kontekst: `getClass().getClassLoader().getResource("DryLips.txt").getFile()`
  - Benyt en Scanner til at læse inputfilen én linje adgangen.
  - Brug split(” ”) på linjen, så hvert ord nu er i et Stringarray
  - Konvertér 1. ord til små bogstaver og første bogstav i resten af ordene til storebogstaver
  - Saml linjen ord til ét langt ord i camelSkrift og udskriv det.

**Ekstra**: Skriv det konverterede output til en tekstfil.