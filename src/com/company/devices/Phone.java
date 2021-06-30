package com.company.devices;
import com.company.Human;
import com.company.selleable;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Phone extends Device implements selleable {
    Double memory;
    Double screenSize;


    public Phone(String producer, String model, Integer yearOfProduction){
        this.producer = producer;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
    }
    @Override
    public void turnOn(){
        System.out.println("This phone "+producer+" "+model+" is now turned on.");
    }
        public boolean sell(Human seller, Human buyer, Double price) throws Exception
        {
            boolean isOwner = false;
            int indexInOwnedPhone = -1;
            for (int i = 0; i < seller.ownedPhones().size(); i++) {
                Phone transactionItem = seller.ownedPhones().get(i);

                if (transactionItem == this) { isOwner = true; indexInOwnedPhone = i; break; }
            }

            if (!isOwner) throw new Exception("Buyer doesn't have a phone.");

            if (buyer.cashAvailable() < price) throw new Exception("Buyer doesn't have enough money");

            seller.incomeCash(price);
            buyer.incomeCash(-price);
            Phone soldPhone = seller.getPhone(indexInOwnedPhone);
            buyer.setPhone(soldPhone);
            seller.removePhone(indexInOwnedPhone);
            System.out.println("Sold");
            return isOwner;
        }

        public void installAnApp(String appName)
        {
            System.out.println("Installed app: "+appName);
        }

        public void installAnApp(String appName, String appVersion)
        {
            System.out.println("Installed app: "+ appName +" version: " + appVersion);
        }

        //Implementation of method installAnnApp with parameter appName, appVersion and serverAddress
        public void installAnApp(String appName, String appVersion, String serverAddress)
        {
            System.out.println("Installed app: "+appName + " version: " + appVersion + " from server: " + serverAddress);
        }

        public void installAnApp(ArrayList<String> appList)
        {
            for (String s : appList) {
                System.out.println("Installed app: " + s);
            }
        }

        public static final String DEFAULT_PROTOCOL = "https";
        public static final String DEFAULT_SERVER_ADDRESS = "www.google.com";
        public static final String DEFAULT_FILENAME = "app.jar";

        public void installAnnApp(URL specificAppURL) throws MalformedURLException {
            if (specificAppURL == null)
            {
                System.out.println("There's no valid adress with apps.");
                System.out.println("Installing app from prime server.");
                URL newURL = new URL(DEFAULT_PROTOCOL, DEFAULT_SERVER_ADDRESS, DEFAULT_FILENAME);
                installAnnApp(newURL);
            }
            else {
                System.out.println("Installed app: " + specificAppURL.getFile() + " from server adress: " + specificAppURL.getHost());
            }
        }

    public Phone()
        {
            this.applicationSet = new HashSet<>();
        }

        public void installAnApp(Application application, Human buyer) throws Exception
        {
            boolean isOwner = false;
            for (int i = 0; i < buyer.ownedPhones().size(); i++) {
                Phone transactionItem = buyer.ownedPhones().get(i);

                if (transactionItem == this) { isOwner = true; break; }
            }
            if (!isOwner) throw new Exception("Buyer doesn't have a phone.");

            if (buyer.cashAvailable() >= application.priceOfApplication)
            {
                this.applicationSet.add(application);
                buyer.incomeCash(-application.priceOfApplication);
                System.out.println("App is installed.");
            }
            else
            {
                throw new Exception("Buyer doesn't have enough money.");
            }
        }

        //method isInstalledApp with Application object as parameter, checks whether application is installed
        public boolean isInstalledApp(Application application)
        {
            return applicationSet.contains(application);
        }

        public boolean isInstalledApp(String applicationName)
        {
            boolean isInstalled = false;
            if (!applicationSet.isEmpty())
            {
                for (Application checkedApplication: applicationSet)
                {
                    if (Objects.equals(checkedApplication.nameOfApplication, applicationName))
                    {
                        isInstalled = true;
                        break;
                    }
                }
            }
            return isInstalled;
        }

        public void listFreeApp()
        {
            if (!applicationSet.isEmpty())
            {
                System.out.println("List of free apps:\n");
                for (Application checkedApplication: applicationSet)
                {
                    if (checkedApplication.priceOfApplication == 0.0)
                    {
                        System.out.println(checkedApplication);
                    }
                }
            }
            else
            {
                System.out.println("There's no apps.");
            }
        }

        public void valueOfInstalledApplications()
        {
            double value = 0.0;
            if (!applicationSet.isEmpty())
            {
                for (Application checkedApplication: applicationSet)
                {
                    value += checkedApplication.priceOfApplication;
                }
                System.out.println("Value of installed apps:" + value);
            }
            else
            {
                System.out.println("There's no app.");
            }
        }

        public void listInstalledApplicationAlphabetically()
        {
            if (!applicationSet.isEmpty())
            {
                Application[] tempList = applicationSet.toArray(new Application[0]);

                for (int i = 0; i < tempList.length; i++)
                {
                    for (int j = i+1; j < tempList.length; j++)
                    {
                        if (tempList[i].nameOfApplication.compareTo(tempList[j].nameOfApplication) > 0)
                        {
                            Application temp = tempList[i];
                            tempList[i] = tempList[j];
                            tempList[j] = temp;
                        }
                    }
                }
                System.out.println("Apps alphabetic:\n");

                for (Application application: tempList
                ) { System.out.println(application); }
            }
            else
            {
                System.out.println("There's no apps.");
            }
        }

        public void listInstalledApplicationByAscendingPrices()
        {
            if (!applicationSet.isEmpty())
            {
                Application[] tempList = applicationSet.toArray(new Application[0]);
                for (int i = 0; i < tempList.length; i++)
                {
                    for (int j = i+1; j < tempList.length; j++)
                    {
                        if (tempList[i].priceOfApplication > tempList[j].priceOfApplication)
                        {
                            Application temp = tempList[i];
                            tempList[i] = tempList[j];
                            tempList[j] = temp;
                        }
                    }
                }
                System.out.println("Apps from low to high:\n");
                for (Application application: tempList
                ) {
                    System.out.println(application);
                }
            }
            else
            {
                System.out.println("There's no app.");
            }
    }
}