package util;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import hibernate.Sale;
import hibernate.Customer;
import hibernate.SaleItem;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;

public class BillPdfGenerator {

    public static File generateBill(Sale sale) throws Exception {

        File dir = new File("bills");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        File pdfFile = new File(dir, "bill_" + sale.getId() + ".pdf");

        Document doc = new Document(new Rectangle(226, 600)); // 80mm receipt
        PdfWriter.getInstance(doc, new FileOutputStream(pdfFile));
        doc.open();

        Font normal = new Font(Font.HELVETICA, 9);
        Font bold = new Font(Font.HELVETICA, 10, Font.BOLD);

        // Header
        doc.add(new Paragraph("ITEM      QTY   PRICE   TOTAL", bold));
        doc.add(new Paragraph("--------------------------------", normal));

        double grandTotal = 0;

        for (SaleItem item : sale.getSaleItems()) {

            String name = item.getStock().getGrnItem().getProduct().getName();
            double qty = item.getQuantity();
            double price = item.getUnitPrice();
            double total = qty*price;

            grandTotal += total;

            doc.add(new Paragraph(
                    String.format("%-8s %3d %6.2f %7.2f",
                            name, qty, price, total),
                    normal
            ));
        }

        doc.add(new Paragraph("================================", normal));
        doc.add(new Paragraph("Thank You!", bold));
        doc.add(new Paragraph("\n\n", normal));

        doc.close();
        return pdfFile;
    }
}
