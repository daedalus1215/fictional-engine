/**
 * Autogenerated by Avro
 * <p>
 * DO NOT EDIT DIRECTLY
 */
package com.food.ordering.system.kafka.order.avro.model;

import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.SchemaStore;
import org.apache.avro.specific.SpecificData;

@org.apache.avro.specific.AvroGenerated
public class RestaurantApprovalRequestAvroModel extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
    public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"RestaurantApprovalRequestAvroModel\",\"namespace\":\"com.food.ordering.system.kafka.order.avro.model\",\"fields\":[{\"name\":\"id\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"sagaId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"restaurantId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"orderId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"restaurantOrderStatus\",\"type\":{\"type\":\"enum\",\"name\":\"RestaurantOrderStatus\",\"symbols\":[\"PAID\"]}},{\"name\":\"products\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"Product\",\"fields\":[{\"name\":\"id\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"logicalType\":\"uuid\"},{\"name\":\"quantity\",\"type\":\"int\"}]}}},{\"name\":\"price\",\"type\":{\"type\":\"bytes\",\"logicalType\":\"decimal\",\"precision\":10,\"scale\":2}},{\"name\":\"createdAt\",\"type\":{\"type\":\"long\",\"logicalType\":\"timestamp-millis\"}}]}");
    private static final long serialVersionUID = -3917361261016430486L;
    private static final SpecificData MODEL$ = new SpecificData();
    private static final BinaryMessageEncoder<RestaurantApprovalRequestAvroModel> ENCODER =
            new BinaryMessageEncoder<RestaurantApprovalRequestAvroModel>(MODEL$, SCHEMA$);
    private static final BinaryMessageDecoder<RestaurantApprovalRequestAvroModel> DECODER =
            new BinaryMessageDecoder<RestaurantApprovalRequestAvroModel>(MODEL$, SCHEMA$);
    private static final org.apache.avro.Conversion<?>[] conversions =
            new org.apache.avro.Conversion<?>[]{
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    new org.apache.avro.Conversions.DecimalConversion(),
                    new org.apache.avro.data.TimeConversions.TimestampMillisConversion(),
                    null
            };
    @SuppressWarnings("unchecked")
    private static final org.apache.avro.io.DatumWriter<RestaurantApprovalRequestAvroModel>
            WRITER$ = (org.apache.avro.io.DatumWriter<RestaurantApprovalRequestAvroModel>) MODEL$.createDatumWriter(SCHEMA$);
    @SuppressWarnings("unchecked")
    private static final org.apache.avro.io.DatumReader<RestaurantApprovalRequestAvroModel>
            READER$ = (org.apache.avro.io.DatumReader<RestaurantApprovalRequestAvroModel>) MODEL$.createDatumReader(SCHEMA$);

    static {
        MODEL$.addLogicalTypeConversion(new org.apache.avro.data.TimeConversions.TimestampMillisConversion());
        MODEL$.addLogicalTypeConversion(new org.apache.avro.Conversions.DecimalConversion());
    }

    private String id;
    private String sagaId;
    private String restaurantId;
    private String orderId;
    private RestaurantOrderStatus restaurantOrderStatus;
    private java.util.List<Product> products;
    private java.math.BigDecimal price;
    private java.time.Instant createdAt;
    /**
     * Default constructor.  Note that this does not initialize fields
     * to their default values from the schema.  If that is desired then
     * one should use <code>newBuilder()</code>.
     */
    public RestaurantApprovalRequestAvroModel() {
    }
    /**
     * All-args constructor.
     * @param id The new value for id
     * @param sagaId The new value for sagaId
     * @param restaurantId The new value for restaurantId
     * @param orderId The new value for orderId
     * @param restaurantOrderStatus The new value for restaurantOrderStatus
     * @param products The new value for products
     * @param price The new value for price
     * @param createdAt The new value for createdAt
     */
    public RestaurantApprovalRequestAvroModel(String id, String sagaId, String restaurantId, String orderId, RestaurantOrderStatus restaurantOrderStatus, java.util.List<Product> products, java.math.BigDecimal price, java.time.Instant createdAt) {
        this.id = id;
        this.sagaId = sagaId;
        this.restaurantId = restaurantId;
        this.orderId = orderId;
        this.restaurantOrderStatus = restaurantOrderStatus;
        this.products = products;
        this.price = price;
        this.createdAt = createdAt.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
    }

    public static org.apache.avro.Schema getClassSchema() {
        return SCHEMA$;
    }

    /**
     * Return the BinaryMessageEncoder instance used by this class.
     * @return the message encoder used by this class
     */
    public static BinaryMessageEncoder<RestaurantApprovalRequestAvroModel> getEncoder() {
        return ENCODER;
    }

    /**
     * Return the BinaryMessageDecoder instance used by this class.
     * @return the message decoder used by this class
     */
    public static BinaryMessageDecoder<RestaurantApprovalRequestAvroModel> getDecoder() {
        return DECODER;
    }

    /**
     * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
     * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
     * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
     */
    public static BinaryMessageDecoder<RestaurantApprovalRequestAvroModel> createDecoder(SchemaStore resolver) {
        return new BinaryMessageDecoder<RestaurantApprovalRequestAvroModel>(MODEL$, SCHEMA$, resolver);
    }

    /**
     * Deserializes a RestaurantApprovalRequestAvroModel from a ByteBuffer.
     * @param b a byte buffer holding serialized data for an instance of this class
     * @return a RestaurantApprovalRequestAvroModel instance decoded from the given buffer
     * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
     */
    public static RestaurantApprovalRequestAvroModel fromByteBuffer(
            java.nio.ByteBuffer b) throws java.io.IOException {
        return DECODER.decode(b);
    }

    /**
     * Creates a new RestaurantApprovalRequestAvroModel RecordBuilder.
     * @return A new RestaurantApprovalRequestAvroModel RecordBuilder
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * Creates a new RestaurantApprovalRequestAvroModel RecordBuilder by copying an existing Builder.
     * @param other The existing builder to copy.
     * @return A new RestaurantApprovalRequestAvroModel RecordBuilder
     */
    public static Builder newBuilder(Builder other) {
        if (other == null) {
            return new Builder();
        } else {
            return new Builder(other);
        }
    }

    /**
     * Creates a new RestaurantApprovalRequestAvroModel RecordBuilder by copying an existing RestaurantApprovalRequestAvroModel instance.
     * @param other The existing instance to copy.
     * @return A new RestaurantApprovalRequestAvroModel RecordBuilder
     */
    public static Builder newBuilder(RestaurantApprovalRequestAvroModel other) {
        if (other == null) {
            return new Builder();
        } else {
            return new Builder(other);
        }
    }

    /**
     * Serializes this RestaurantApprovalRequestAvroModel to a ByteBuffer.
     * @return a buffer holding the serialized data for this instance
     * @throws java.io.IOException if this instance could not be serialized
     */
    public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
        return ENCODER.encode(this);
    }

    public org.apache.avro.specific.SpecificData getSpecificData() {
        return MODEL$;
    }

    public org.apache.avro.Schema getSchema() {
        return SCHEMA$;
    }

    // Used by DatumWriter.  Applications should not call.
    public Object get(int field$) {
        switch (field$) {
            case 0:
                return id;
            case 1:
                return sagaId;
            case 2:
                return restaurantId;
            case 3:
                return orderId;
            case 4:
                return restaurantOrderStatus;
            case 5:
                return products;
            case 6:
                return price;
            case 7:
                return createdAt;
            default:
                throw new IndexOutOfBoundsException("Invalid index: " + field$);
        }
    }

    @Override
    public org.apache.avro.Conversion<?> getConversion(int field) {
        return conversions[field];
    }

    // Used by DatumReader.  Applications should not call.
    @SuppressWarnings(value = "unchecked")
    public void put(int field$, Object value$) {
        switch (field$) {
            case 0:
                id = value$ != null ? value$.toString() : null;
                break;
            case 1:
                sagaId = value$ != null ? value$.toString() : null;
                break;
            case 2:
                restaurantId = value$ != null ? value$.toString() : null;
                break;
            case 3:
                orderId = value$ != null ? value$.toString() : null;
                break;
            case 4:
                restaurantOrderStatus = (RestaurantOrderStatus) value$;
                break;
            case 5:
                products = (java.util.List<Product>) value$;
                break;
            case 6:
                price = (java.math.BigDecimal) value$;
                break;
            case 7:
                createdAt = (java.time.Instant) value$;
                break;
            default:
                throw new IndexOutOfBoundsException("Invalid index: " + field$);
        }
    }

    /**
     * Gets the value of the 'id' field.
     * @return The value of the 'id' field.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the 'id' field.
     * @param value the value to set.
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the 'sagaId' field.
     * @return The value of the 'sagaId' field.
     */
    public String getSagaId() {
        return sagaId;
    }

    /**
     * Sets the value of the 'sagaId' field.
     * @param value the value to set.
     */
    public void setSagaId(String value) {
        this.sagaId = value;
    }

    /**
     * Gets the value of the 'restaurantId' field.
     * @return The value of the 'restaurantId' field.
     */
    public String getRestaurantId() {
        return restaurantId;
    }

    /**
     * Sets the value of the 'restaurantId' field.
     * @param value the value to set.
     */
    public void setRestaurantId(String value) {
        this.restaurantId = value;
    }

    /**
     * Gets the value of the 'orderId' field.
     * @return The value of the 'orderId' field.
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * Sets the value of the 'orderId' field.
     * @param value the value to set.
     */
    public void setOrderId(String value) {
        this.orderId = value;
    }

    /**
     * Gets the value of the 'restaurantOrderStatus' field.
     * @return The value of the 'restaurantOrderStatus' field.
     */
    public RestaurantOrderStatus getRestaurantOrderStatus() {
        return restaurantOrderStatus;
    }

    /**
     * Sets the value of the 'restaurantOrderStatus' field.
     * @param value the value to set.
     */
    public void setRestaurantOrderStatus(RestaurantOrderStatus value) {
        this.restaurantOrderStatus = value;
    }

    /**
     * Gets the value of the 'products' field.
     * @return The value of the 'products' field.
     */
    public java.util.List<Product> getProducts() {
        return products;
    }

    /**
     * Sets the value of the 'products' field.
     * @param value the value to set.
     */
    public void setProducts(java.util.List<Product> value) {
        this.products = value;
    }

    /**
     * Gets the value of the 'price' field.
     * @return The value of the 'price' field.
     */
    public java.math.BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the value of the 'price' field.
     * @param value the value to set.
     */
    public void setPrice(java.math.BigDecimal value) {
        this.price = value;
    }

    /**
     * Gets the value of the 'createdAt' field.
     * @return The value of the 'createdAt' field.
     */
    public java.time.Instant getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the value of the 'createdAt' field.
     * @param value the value to set.
     */
    public void setCreatedAt(java.time.Instant value) {
        this.createdAt = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
    }

    @Override
    public void writeExternal(java.io.ObjectOutput out)
            throws java.io.IOException {
        WRITER$.write(this, SpecificData.getEncoder(out));
    }

    @Override
    public void readExternal(java.io.ObjectInput in)
            throws java.io.IOException {
        READER$.read(this, SpecificData.getDecoder(in));
    }

    /**
     * RecordBuilder for RestaurantApprovalRequestAvroModel instances.
     */
    @org.apache.avro.specific.AvroGenerated
    public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<RestaurantApprovalRequestAvroModel>
            implements org.apache.avro.data.RecordBuilder<RestaurantApprovalRequestAvroModel> {

        private String id;
        private String sagaId;
        private String restaurantId;
        private String orderId;
        private RestaurantOrderStatus restaurantOrderStatus;
        private java.util.List<Product> products;
        private java.math.BigDecimal price;
        private java.time.Instant createdAt;

        /** Creates a new Builder */
        private Builder() {
            super(SCHEMA$, MODEL$);
        }

        /**
         * Creates a Builder by copying an existing Builder.
         * @param other The existing Builder to copy.
         */
        private Builder(Builder other) {
            super(other);
            if (isValidValue(fields()[0], other.id)) {
                this.id = data().deepCopy(fields()[0].schema(), other.id);
                fieldSetFlags()[0] = other.fieldSetFlags()[0];
            }
            if (isValidValue(fields()[1], other.sagaId)) {
                this.sagaId = data().deepCopy(fields()[1].schema(), other.sagaId);
                fieldSetFlags()[1] = other.fieldSetFlags()[1];
            }
            if (isValidValue(fields()[2], other.restaurantId)) {
                this.restaurantId = data().deepCopy(fields()[2].schema(), other.restaurantId);
                fieldSetFlags()[2] = other.fieldSetFlags()[2];
            }
            if (isValidValue(fields()[3], other.orderId)) {
                this.orderId = data().deepCopy(fields()[3].schema(), other.orderId);
                fieldSetFlags()[3] = other.fieldSetFlags()[3];
            }
            if (isValidValue(fields()[4], other.restaurantOrderStatus)) {
                this.restaurantOrderStatus = data().deepCopy(fields()[4].schema(), other.restaurantOrderStatus);
                fieldSetFlags()[4] = other.fieldSetFlags()[4];
            }
            if (isValidValue(fields()[5], other.products)) {
                this.products = data().deepCopy(fields()[5].schema(), other.products);
                fieldSetFlags()[5] = other.fieldSetFlags()[5];
            }
            if (isValidValue(fields()[6], other.price)) {
                this.price = data().deepCopy(fields()[6].schema(), other.price);
                fieldSetFlags()[6] = other.fieldSetFlags()[6];
            }
            if (isValidValue(fields()[7], other.createdAt)) {
                this.createdAt = data().deepCopy(fields()[7].schema(), other.createdAt);
                fieldSetFlags()[7] = other.fieldSetFlags()[7];
            }
        }

        /**
         * Creates a Builder by copying an existing RestaurantApprovalRequestAvroModel instance
         * @param other The existing instance to copy.
         */
        private Builder(RestaurantApprovalRequestAvroModel other) {
            super(SCHEMA$, MODEL$);
            if (isValidValue(fields()[0], other.id)) {
                this.id = data().deepCopy(fields()[0].schema(), other.id);
                fieldSetFlags()[0] = true;
            }
            if (isValidValue(fields()[1], other.sagaId)) {
                this.sagaId = data().deepCopy(fields()[1].schema(), other.sagaId);
                fieldSetFlags()[1] = true;
            }
            if (isValidValue(fields()[2], other.restaurantId)) {
                this.restaurantId = data().deepCopy(fields()[2].schema(), other.restaurantId);
                fieldSetFlags()[2] = true;
            }
            if (isValidValue(fields()[3], other.orderId)) {
                this.orderId = data().deepCopy(fields()[3].schema(), other.orderId);
                fieldSetFlags()[3] = true;
            }
            if (isValidValue(fields()[4], other.restaurantOrderStatus)) {
                this.restaurantOrderStatus = data().deepCopy(fields()[4].schema(), other.restaurantOrderStatus);
                fieldSetFlags()[4] = true;
            }
            if (isValidValue(fields()[5], other.products)) {
                this.products = data().deepCopy(fields()[5].schema(), other.products);
                fieldSetFlags()[5] = true;
            }
            if (isValidValue(fields()[6], other.price)) {
                this.price = data().deepCopy(fields()[6].schema(), other.price);
                fieldSetFlags()[6] = true;
            }
            if (isValidValue(fields()[7], other.createdAt)) {
                this.createdAt = data().deepCopy(fields()[7].schema(), other.createdAt);
                fieldSetFlags()[7] = true;
            }
        }

        /**
         * Gets the value of the 'id' field.
         * @return The value.
         */
        public String getId() {
            return id;
        }


        /**
         * Sets the value of the 'id' field.
         * @param value The value of 'id'.
         * @return This builder.
         */
        public Builder setId(String value) {
            validate(fields()[0], value);
            this.id = value;
            fieldSetFlags()[0] = true;
            return this;
        }

        /**
         * Checks whether the 'id' field has been set.
         * @return True if the 'id' field has been set, false otherwise.
         */
        public boolean hasId() {
            return fieldSetFlags()[0];
        }


        /**
         * Clears the value of the 'id' field.
         * @return This builder.
         */
        public Builder clearId() {
            id = null;
            fieldSetFlags()[0] = false;
            return this;
        }

        /**
         * Gets the value of the 'sagaId' field.
         * @return The value.
         */
        public String getSagaId() {
            return sagaId;
        }


        /**
         * Sets the value of the 'sagaId' field.
         * @param value The value of 'sagaId'.
         * @return This builder.
         */
        public Builder setSagaId(String value) {
            validate(fields()[1], value);
            this.sagaId = value;
            fieldSetFlags()[1] = true;
            return this;
        }

        /**
         * Checks whether the 'sagaId' field has been set.
         * @return True if the 'sagaId' field has been set, false otherwise.
         */
        public boolean hasSagaId() {
            return fieldSetFlags()[1];
        }


        /**
         * Clears the value of the 'sagaId' field.
         * @return This builder.
         */
        public Builder clearSagaId() {
            sagaId = null;
            fieldSetFlags()[1] = false;
            return this;
        }

        /**
         * Gets the value of the 'restaurantId' field.
         * @return The value.
         */
        public String getRestaurantId() {
            return restaurantId;
        }


        /**
         * Sets the value of the 'restaurantId' field.
         * @param value The value of 'restaurantId'.
         * @return This builder.
         */
        public Builder setRestaurantId(String value) {
            validate(fields()[2], value);
            this.restaurantId = value;
            fieldSetFlags()[2] = true;
            return this;
        }

        /**
         * Checks whether the 'restaurantId' field has been set.
         * @return True if the 'restaurantId' field has been set, false otherwise.
         */
        public boolean hasRestaurantId() {
            return fieldSetFlags()[2];
        }


        /**
         * Clears the value of the 'restaurantId' field.
         * @return This builder.
         */
        public Builder clearRestaurantId() {
            restaurantId = null;
            fieldSetFlags()[2] = false;
            return this;
        }

        /**
         * Gets the value of the 'orderId' field.
         * @return The value.
         */
        public String getOrderId() {
            return orderId;
        }


        /**
         * Sets the value of the 'orderId' field.
         * @param value The value of 'orderId'.
         * @return This builder.
         */
        public Builder setOrderId(String value) {
            validate(fields()[3], value);
            this.orderId = value;
            fieldSetFlags()[3] = true;
            return this;
        }

        /**
         * Checks whether the 'orderId' field has been set.
         * @return True if the 'orderId' field has been set, false otherwise.
         */
        public boolean hasOrderId() {
            return fieldSetFlags()[3];
        }


        /**
         * Clears the value of the 'orderId' field.
         * @return This builder.
         */
        public Builder clearOrderId() {
            orderId = null;
            fieldSetFlags()[3] = false;
            return this;
        }

        /**
         * Gets the value of the 'restaurantOrderStatus' field.
         * @return The value.
         */
        public RestaurantOrderStatus getRestaurantOrderStatus() {
            return restaurantOrderStatus;
        }


        /**
         * Sets the value of the 'restaurantOrderStatus' field.
         * @param value The value of 'restaurantOrderStatus'.
         * @return This builder.
         */
        public Builder setRestaurantOrderStatus(RestaurantOrderStatus value) {
            validate(fields()[4], value);
            this.restaurantOrderStatus = value;
            fieldSetFlags()[4] = true;
            return this;
        }

        /**
         * Checks whether the 'restaurantOrderStatus' field has been set.
         * @return True if the 'restaurantOrderStatus' field has been set, false otherwise.
         */
        public boolean hasRestaurantOrderStatus() {
            return fieldSetFlags()[4];
        }


        /**
         * Clears the value of the 'restaurantOrderStatus' field.
         * @return This builder.
         */
        public Builder clearRestaurantOrderStatus() {
            restaurantOrderStatus = null;
            fieldSetFlags()[4] = false;
            return this;
        }

        /**
         * Gets the value of the 'products' field.
         * @return The value.
         */
        public java.util.List<Product> getProducts() {
            return products;
        }


        /**
         * Sets the value of the 'products' field.
         * @param value The value of 'products'.
         * @return This builder.
         */
        public Builder setProducts(java.util.List<Product> value) {
            validate(fields()[5], value);
            this.products = value;
            fieldSetFlags()[5] = true;
            return this;
        }

        /**
         * Checks whether the 'products' field has been set.
         * @return True if the 'products' field has been set, false otherwise.
         */
        public boolean hasProducts() {
            return fieldSetFlags()[5];
        }


        /**
         * Clears the value of the 'products' field.
         * @return This builder.
         */
        public Builder clearProducts() {
            products = null;
            fieldSetFlags()[5] = false;
            return this;
        }

        /**
         * Gets the value of the 'price' field.
         * @return The value.
         */
        public java.math.BigDecimal getPrice() {
            return price;
        }


        /**
         * Sets the value of the 'price' field.
         * @param value The value of 'price'.
         * @return This builder.
         */
        public Builder setPrice(java.math.BigDecimal value) {
            validate(fields()[6], value);
            this.price = value;
            fieldSetFlags()[6] = true;
            return this;
        }

        /**
         * Checks whether the 'price' field has been set.
         * @return True if the 'price' field has been set, false otherwise.
         */
        public boolean hasPrice() {
            return fieldSetFlags()[6];
        }


        /**
         * Clears the value of the 'price' field.
         * @return This builder.
         */
        public Builder clearPrice() {
            price = null;
            fieldSetFlags()[6] = false;
            return this;
        }

        /**
         * Gets the value of the 'createdAt' field.
         * @return The value.
         */
        public java.time.Instant getCreatedAt() {
            return createdAt;
        }


        /**
         * Sets the value of the 'createdAt' field.
         * @param value The value of 'createdAt'.
         * @return This builder.
         */
        public Builder setCreatedAt(java.time.Instant value) {
            validate(fields()[7], value);
            this.createdAt = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
            fieldSetFlags()[7] = true;
            return this;
        }

        /**
         * Checks whether the 'createdAt' field has been set.
         * @return True if the 'createdAt' field has been set, false otherwise.
         */
        public boolean hasCreatedAt() {
            return fieldSetFlags()[7];
        }


        /**
         * Clears the value of the 'createdAt' field.
         * @return This builder.
         */
        public Builder clearCreatedAt() {
            fieldSetFlags()[7] = false;
            return this;
        }

        @Override
        @SuppressWarnings("unchecked")
        public RestaurantApprovalRequestAvroModel build() {
            try {
                RestaurantApprovalRequestAvroModel record = new RestaurantApprovalRequestAvroModel();
                record.id = fieldSetFlags()[0] ? this.id : (String) defaultValue(fields()[0]);
                record.sagaId = fieldSetFlags()[1] ? this.sagaId : (String) defaultValue(fields()[1]);
                record.restaurantId = fieldSetFlags()[2] ? this.restaurantId : (String) defaultValue(fields()[2]);
                record.orderId = fieldSetFlags()[3] ? this.orderId : (String) defaultValue(fields()[3]);
                record.restaurantOrderStatus = fieldSetFlags()[4] ? this.restaurantOrderStatus : (RestaurantOrderStatus) defaultValue(fields()[4]);
                record.products = fieldSetFlags()[5] ? this.products : (java.util.List<Product>) defaultValue(fields()[5]);
                record.price = fieldSetFlags()[6] ? this.price : (java.math.BigDecimal) defaultValue(fields()[6]);
                record.createdAt = fieldSetFlags()[7] ? this.createdAt : (java.time.Instant) defaultValue(fields()[7]);
                return record;
            } catch (org.apache.avro.AvroMissingFieldException e) {
                throw e;
            } catch (Exception e) {
                throw new org.apache.avro.AvroRuntimeException(e);
            }
        }
    }

}










